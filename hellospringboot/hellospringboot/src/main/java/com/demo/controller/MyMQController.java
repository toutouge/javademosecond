package com.demo.controller;

import com.demo.mq.model.MyModel;
import com.demo.mq.producer.MyProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by toutou on 2018/12/15.
 */
@RestController
@Slf4j
public class MyMQController {
    @Autowired
    MyProducer myProducers;
 
    @GetMapping("/mq/producer")
    public String myProducer(String content){
        MyModel model = new MyModel();
        model.setId(UUID.randomUUID());
        model.setInfo(content);
        myProducers.sendMsg(model);
        return "已发送：" + content;
    }
}
