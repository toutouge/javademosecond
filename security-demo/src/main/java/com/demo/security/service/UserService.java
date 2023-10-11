package com.demo.security.service;

import com.demo.security.model.po.UserPo;

/**
 * @Author chen bo
 * @Date 2023/12
 * @Des
 */
public interface UserService {
    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    UserPo getUserByUserName(String userName);
}
