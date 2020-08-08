package com.toutou.service.impl;

import com.toutou.dao.UserMapper;
import com.toutou.model.po.User;
import com.toutou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author toutou
 * @date by 2020/08
 * @des
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    public User getUserById(int id){
        return userMapper.selectByPrimaryKey(id);
    }
}

