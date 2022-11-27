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

    /**
     * 写入redis测试
     * @param id
     * @param text
     * @return
     */
    @RequestMapping("/set")
    public String set(int id, String text){
        return demoService.set(id,text);
    }

    /**
     * 读取redis测试
     * @param id
     * @return
     */
    @RequestMapping("/get")
    public String get(int id){
        return demoService.get(id);
    }
}
