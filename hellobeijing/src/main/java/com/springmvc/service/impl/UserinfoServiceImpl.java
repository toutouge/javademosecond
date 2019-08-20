package com.springmvc.service.impl;

import com.springmvc.dao.UserinfoMapper;
import com.springmvc.entity.Userinfo;
import com.springmvc.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by toutou on 2018/5/27.
 */
@Service
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    private UserinfoMapper mapper;
    public int insert(Userinfo record) {
        return mapper.insert(record);
    }

    public ArrayList<Userinfo> selectSelective(Userinfo record) {
        return mapper.selectSelective(record);
    }
}
