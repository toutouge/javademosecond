package com.demo.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chen bo
 * @Date 2023/12
 * @Des
 */
@RestController
public class HomeController {
    @GetMapping("/hello")
    public String hello(){
        return "Security demo.";
    }
}
