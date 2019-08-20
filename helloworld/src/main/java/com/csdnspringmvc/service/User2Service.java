package com.csdnspringmvc.service;

import com.csdnspringmvc.dao.User2Mapper;
import com.csdnspringmvc.entity.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by toutou on 2018/4/27.
 */
@Service
public class User2Service {
    @Autowired
    private User2Mapper mapper;

    //public int insert(User2 user) {
    //    return mapper.insertSelective(user2);
    //}

    public ArrayList<User2> selectSelective(User2 user){
        return mapper.selectSelective(user);
    }

    public int insert(User2 record){return mapper.insert(record);}
}
