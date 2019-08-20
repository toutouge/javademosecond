package com.demo.service;

import com.demo.pojo.UserDetails;

/**
 * Created by toutou on 2019/1/20.
 */
public interface CacheService {
    UserDetails getUserDetailsByUid(int uid);

    UserDetails updateUserInfo(UserDetails userDetails);

    int delUserInfoById(int uid);
}
