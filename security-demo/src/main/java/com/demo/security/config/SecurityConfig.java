package com.demo.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author chen bo
 * @Date 2023/12
 * @Des
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()                // HttpBasic
//        http.formLogin()              // 表单方式
                .and()
                .authorizeRequests()  // 授权配置
                .anyRequest()         // 所有请求
                .authenticated();     // 都需要认证
    }
}