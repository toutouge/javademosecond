package com.demo.service;

import com.demo.dao.UserDetailsMapper;
import com.demo.pojo.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by toutou on 2019/1/20.
 */
@Service
public class CacheServiceImpl implements CacheService{

    @Autowired
    UserDetailsMapper userDetailsMapper;

    @Override
    @Cacheable(value = "user_details", key = "#uid", unless="#result == null")
    public UserDetails getUserDetailsByUid(int uid){
        System.out.println(" Cacheable 有请求过来了");
        UserDetails userDetails = userDetailsMapper.getUserDetailsByUid(uid);
        return userDetails;
    }

    @Override
    @CachePut(value = "user_details", key = "#user.id")
    public UserDetails updateUserInfo(UserDetails user){
        System.out.println(" CachePut 有请求过来了");
        if(userDetailsMapper.updateByPrimaryKeySelective(user) > 0) {
            // 这里也可以直接在updateByPrimaryKeySelective的方法里，修改后直接查询出该记录返回UserDetails实例，看需求。
            user = userDetailsMapper.getUserDetailsByUid(user.getId());
            return user;
        }else{
            return null;
        }
    }

    @Override
    @CacheEvict(value = "user_details", key = "#uid")
    public int delUserInfoById(int uid){
        System.out.println(" CacheEvict 有请求过来了");
        return userDetailsMapper.deleteByPrimaryKey(uid);
    }
}
