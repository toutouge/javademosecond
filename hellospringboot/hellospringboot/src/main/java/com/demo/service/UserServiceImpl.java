package com.demo.service;

import com.demo.dao.UserAccountMapper;
import com.demo.dao.UserDetailsMapper;
import com.demo.dao.UserPositionMapper;
import com.demo.pojo.UserAccount;
import com.demo.pojo.UserDetails;
import com.demo.pojo.UserPosition;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by toutou on 2018/10/15.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDetailsMapper userDetailsMapper;

    @Autowired
    UserPositionMapper userPositionMapper;

    @Autowired
    StringRedisTemplate template;

    @Autowired
    UserAccountMapper userAccountMapper;

    @Resource
    RedisTemplate<String, List<UserPosition>>  redisTemplate;

    static final String KEY_USER_INFO__NAME = "com_demo_user_info_007_%s";

    @Override
    public String getUserNameById(Integer uid){
        String userName = "未知用户";
        try {
            userName = template.opsForValue().get(String.format(KEY_USER_INFO__NAME, uid));
            if (Strings.isNullOrEmpty(userName)) {
                // Redis中没有就读数据库
                UserDetails userDetails = getUserDetailsByUid(uid);
                if (userDetails != null && !Strings.isNullOrEmpty(userDetails.getCity())) {
                    userName = userDetails.getCity();
                }
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }

        return userName;
    }

    @Override
    public void setUserNameById(Integer uid, String userName){
        template.opsForValue().setIfAbsent("key", "value");
        //String result = template.execute(new RedisCallback<String>() {
        //    @Override
        //    public String doInRedis(RedisConnection connection) throws DataAccessException {
        //        JedisCommands commands = (JedisCommands) connection.getNativeConnection();
        //        return commands.set(key, "锁定的资源", "NX", "PX", 3000);
        //    }
        //});
        template.opsForValue().set(String.format(KEY_USER_INFO__NAME, uid), userName);
    }

    @Override
    public UserDetails getUserDetailsByUid(int uid){
        return userDetailsMapper.getUserDetailsByUid(uid);
    }

    @Override
    public List<UserDetails> getUserDetails(){
        return userDetailsMapper.getUserDetails();
    }

    @Override
    public List<UserPosition> getVicinity(BigDecimal minlng, BigDecimal maxlng, BigDecimal minlat, BigDecimal maxlat){return userPositionMapper.getvicinity(minlng, maxlng, minlat, maxlat);}

    @Override
    public List<UserPosition> getvicinitysort(BigDecimal longitude,BigDecimal latitude){return userPositionMapper.getvicinitysort(longitude, latitude);}

    /**
     * 返回附近的人信息
     * @param longitude
     * @param latitude
     * @return list
     * @author toutou
     */
    @Override
    public List<UserPosition> getVicinityList(BigDecimal longitude,BigDecimal latitude){
        String key = String.format("vicinity_list%s%s",longitude.toString(), latitude.toString());
        List<UserPosition> list = redisTemplate.opsForValue().get(key);
        if(list !=null){
            return list;
        }else{
            synchronized (this){
                list = redisTemplate.opsForValue().get(key);
                if(list ==null) {
                    list = userPositionMapper.getvicinitysort(longitude, latitude);
                    if (list != null && list.size() > 0) {
                        redisTemplate.opsForValue().set(key, list, 30, TimeUnit.MINUTES);
                    }else{
                        // 缓存空数据是为了防止缓存击穿，下面的章节会讲到缓存穿透。
                        redisTemplate.opsForValue().set(key, list, 30, TimeUnit.SECONDS);
                    }
                }
            }
        }

        return list;
    }

    @Override
    public UserAccount getUserByAccount(String account){
        return userAccountMapper.getUserByAccount(account);
    }
}