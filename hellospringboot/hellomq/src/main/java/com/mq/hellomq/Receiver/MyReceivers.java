package com.mq.hellomq.Receiver;

import com.mq.hellomq.common.RabbitConfigs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by toutou on 2018/12/15.
 */
@Component
@RabbitListener(queues = RabbitConfigs.QUEUE_A)
public class MyReceivers {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String content) {
        logger.info("接收处理队列A当中的消息： " + content);
    }
}