package com.test.controller;

import com.test.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chen bo
 * @Date 2022/11
 * @Des
 */
@RestController
public class DemoController {
    @Autowired
    DemoService demoService;

    @RequestMapping("/set")
    public String set(int id, String text){
        return demoService.set(id,text);
    }

    @RequestMapping("/get")
    public String get(int id){
        return demoService.get(id);
    }
}
