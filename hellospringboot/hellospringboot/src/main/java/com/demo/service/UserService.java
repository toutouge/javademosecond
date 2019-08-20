package com.demo.service;

import com.demo.pojo.UserAccount;
import com.demo.pojo.UserDetails;
import com.demo.pojo.UserPosition;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by toutou on 2018/10/15.
 */
public interface UserService {
    UserDetails getUserDetailsByUid(int uid);
    List<UserDetails> getUserDetails();
    List<UserPosition> getVicinity(BigDecimal minlng, BigDecimal maxlng, BigDecimal minlat, BigDecimal maxlat);
    List<UserPosition> getvicinitysort(BigDecimal longitude,BigDecimal latitude);
    String getUserNameById(Integer uid);
    void setUserNameById(Integer uid, String userName);
    UserAccount getUserByAccount(String account);
    List<UserPosition> getVicinityList(BigDecimal longitude,BigDecimal latitude);
}