package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author chen bo
 * @Date 2022/11
 * @Des
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    StringRedisTemplate template;

    @Override
    public String set(int id, String text){
        String redisKey = String.format("test:text:%d", id);
        template.opsForValue().set(redisKey, text, 120, TimeUnit.SECONDS);
        return text;
    }

    @Override
    public String get(int id){
        String redisKey = String.format("test:text:%d", id);
        return String.format("value:%s,time:%d",
                template.opsForValue().get(redisKey),
                template.opsForValue().getOperations().getExpire(redisKey));
    }
}
