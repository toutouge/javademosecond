package com.csdnspringmvc.service;

import com.csdnspringmvc.dao.User1Mapper;
import com.csdnspringmvc.entity.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by toutou on 2018/2/16.
 */
@Service
public class User1Service {
    @Autowired
    private User1Mapper userMapper;

    public int insert(User1 user) {
        return userMapper.insertSelective(user);
    }

    public ArrayList<User1> selectAll(){
        return userMapper.selectAll();
    }
}
