package com.demo.security.config;

import com.demo.security.model.UserLogin;
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

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserLogin user = new UserLogin();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("123456"));

        log.info("password : " + user.getPassword());
        return user;
    }
}
