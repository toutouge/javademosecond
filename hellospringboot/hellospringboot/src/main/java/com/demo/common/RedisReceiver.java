package com.demo.common;

import org.springframework.stereotype.Component;

/**
 * Created by toutou on 2019/2/23.
 */
@Component
public class RedisReceiver {
    public void receiveMessage(String message) {
        // TODO 这里是收到通道的消息之后执行的方法
        System.out.println(message);
    }
}