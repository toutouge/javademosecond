package com.demo.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author chen bo
 * @Date 2023/12
 * @Des
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        // 默认打印出登陆信息
//        httpServletResponse.setContentType("application/json;charset=utf-8");
//        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(authentication));
        // 跳转访问页面
//        SavedRequest savedRequest = requestCache.getRequest(httpServletRequest, httpServletResponse);
//        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, savedRequest.getRedirectUrl());
        // 跳转制定页面
        SavedRequest savedRequest = requestCache.getRequest(httpServletRequest, httpServletResponse);
        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "hello.html");
    }
}