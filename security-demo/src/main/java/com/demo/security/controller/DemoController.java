package com.demo.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author chen bo
 * @Date 2023/12
 * @Des
 */
@RestController
public class DemoController {
    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @GetMapping("/authentication/require")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String url = savedRequest.getRedirectUrl();
            // 为了方便测试，我们设置只有访问url中是以.html结尾时，才会跳转登录页，其它形式的全部返回提示语(访问资源需要身份认证)。具体业务中这里可以按需求设置。
            if (StringUtils.endsWithIgnoreCase(url, ".html")) {
                redirectStrategy.sendRedirect(request, response, "/login.html");
            }
        }

        return "访问资源需要身份认证";
    }
}
