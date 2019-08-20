package com.demo.controller;

import com.demo.pojo.UserDetails;
import com.demo.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by toutou on 2019/1/20.
 */
@RestController
@Slf4j
public class CacheController {

    @Autowired
    CacheService cacheService;

    @RequestMapping(value = "/cache/getuserbyid")
    public UserDetails getUserDetailsByUid(int uid){
        try {
            return cacheService.getUserDetailsByUid(uid);
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    @RequestMapping(value = "/cache/updateuserinfo")
    public int updateUserInfo(int uid, String city){
        UserDetails userDetails = new UserDetails();
        userDetails.setId(uid);
        userDetails.setCity(city);
        userDetails = cacheService.updateUserInfo(userDetails);
        return userDetails == null ? 0 : userDetails.getUid();
    }

    @RequestMapping(value = "/cache/deluserinfobyid")
    public int delUserInfoById(int uid){
        return cacheService.delUserInfoById(uid);
    }
}
