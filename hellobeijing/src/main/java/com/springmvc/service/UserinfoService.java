package com.springmvc.service;

import com.springmvc.entity.Userinfo;

import java.util.ArrayList;

/**
 * Created by toutou on 2018/5/27.
 */
public interface UserinfoService {
    int insert(Userinfo record);

    ArrayList<Userinfo> selectSelective(Userinfo record);
}
