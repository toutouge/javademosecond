package com.demo.controller;

import com.demo.common.RedisLockHelper;
import com.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Date;

/**
 * Created by toutou on 2019/1/20.
 */
@RestController
@Slf4j
public class RedisController {

    @Autowired
    UserService userService;

    @Autowired
    RedisLockHelper redisLockHelper;

    /**
     * 超时时间 5s
     */
    private static final int TIMEOUT = 5*1000;

    @Autowired
    StringRedisTemplate template;

    @RequestMapping(value = "/syncmessage")
    public String SyncMessage(){
        for(int i = 1; i <= 5; i++){
            try{
                // 为了模拟消息，sleep一下。
                Thread.sleep(2000);
            }catch(InterruptedException ex){}
            template.convertAndSend("channel:test", String.format("我是消息{%d}号: %tT", i, new Date()));
        }

        return "5";
    }

    //region Redis事物测试代码

    //@Transactional
    //@RequestMapping(value = "/testredistran1")
    //public String testRedisTran1()
    //{
    //    template.opsForValue().set("test1a", "test1a");
    //    template.opsForValue().set("test1b", "test1b");
    //    template.opsForValue().set("test1c", "test1c");
    //    return "1";
    //}
    //
    //@Transactional
    //@RequestMapping(value = "/testredistran2")
    //public String testRedisTran2()
    //{
    //    template.opsForValue().set("test2a", "test2a");
    //    template.opsForValue().set(null, "test2b");
    //    template.opsForValue().set("test2c", "test2c");
    //    return "2";
    //}

    // endregion

    @RequestMapping(value = "/setcity")
    public String testCodis(String name)
    {
        template.opsForValue().set("city", name);
        String value = template.opsForValue().get("city");
        return value;
    }

    @RequestMapping(value = "/testredistran3")
    public String testRedisTran3()
    {
        //开启事务
        template.multi();
        template.opsForValue().set("test3a", "test3a");
        template.opsForValue().set(null, "test3b");
        template.opsForValue().set("test3c", "test3c");
        //关闭事务
        template.exec();
        return "3";
    }

    @RequestMapping(value = "/getusernamebyid")
    public String getUserNameById(Integer uid)
    {
        return userService.getUserNameById(uid);
    }

    @RequestMapping(value = "/setusernamebyid")
    public String setUserNameById(Integer uid, String uname)
    {
        userService.setUserNameById(uid, uname);
        return "设置成功";
    }

    @RequestMapping(value = "/jedistest")
    public String jedisTest(String key){
        // 创建一个jedis对象
        Jedis jedis = new Jedis("localhost", 1900);
        // 直接调用jedis对象的方法，方法名称和redis的命令一致
        //jedis.set("key1", "test01");
        String key1 = "";
        try {
            key1 = jedis.get(key);
            System.out.println(key1 + " " + key1);
        }catch(Exception e){
            key1 = e.toString();
        }
        // 关闭jedis
        jedis.close();
        return key1;
    }

    @RequestMapping(value = "/seckilling")
    public String Seckilling(String targetId){
        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if(!redisLockHelper.lock(targetId,String.valueOf(time))){
            return "排队人数太多，请稍后再试.";
        }

        int surplusCount = 0;
        // 查询该商品库存，为0则活动结束 e.g. getStockByTargetId
        if(surplusCount==0){
            return "活动结束.";
        }else {
            // 下单 e.g. buyStockByTargetId

            //减库存 不做处理的话，高并发下会出现超卖的情况，下单数，大于减库存的情况。虽然这里减了，但由于并发，减的库存还没存到map中去。新的并发拿到的是原来的库存
            surplusCount =surplusCount-1;
            try{
                Thread.sleep(100);//模拟减库存的处理时间
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            // 减库存操作数据库 e.g. updateStockByTargetId

            // buyStockByTargetId 和 updateStockByTargetId 可以同步完成(或者事物)，保证原子性。
        }

        //解锁
        redisLockHelper.unlock(targetId,String.valueOf(time));

        return "恭喜您，秒杀成功。";
    }
}
