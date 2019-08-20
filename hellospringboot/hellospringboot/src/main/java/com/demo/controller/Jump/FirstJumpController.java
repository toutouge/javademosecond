package com.demo.controller.Jump;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by toutou on 2019/1/27.
 */
@Controller
@Slf4j
public class FirstJumpController {
    @RequestMapping(value = "/myfirst")
    public String MyFirst(){
        // 如果使用ModelAndView方式: return new ModelAndView("forward:/mysecond");
        // forward是请求转发，是服务器端行为，相当于一次请求，地址栏的 URL 不会改变。
        return "forward:/mysecond";
    }

    @RequestMapping(value = "/myfirst2")
    public String MyFirst2(){
        // redirect是请求重定向，是客户端行为，相当于两次请求，地址栏的 URL 会改变。
        return "redirect:/mysecond";
    }

    @RequestMapping(value = "/myfirst3")
    public String MyFirst3(String name){
        // redirect是请求重定向，是客户端行为，相当于两次请求，地址栏的 URL 会改变。
        return "redirect:/mysecond2?name=" + name;
    }
}
