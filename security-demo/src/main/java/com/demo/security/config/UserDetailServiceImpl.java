package com.demo.security.config;

import com.demo.security.model.dto.UserLogin;
import com.demo.security.model.po.UserPo;
import com.demo.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author chen bo
 * @Date 2023/12
 * @Des
 */
@Configuration
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserPo userPo = userService.getUserByUserName(userName);
        if(userPo == null){
            throw new RuntimeException("用户名或密码错误");
        }

        UserLogin user = new UserLogin();
        user.setUsername(userPo.getUserName());
        user.setPassword(passwordEncoder.encode(userPo.getPwd()));

        log.info("password : " + user.getPassword());
        return user;
    }
}
