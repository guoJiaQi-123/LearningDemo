package com.tyut.itbaizhanspringbootrocketmq.producer;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @author OldGj 2024/5/3
 * @apiNote 消息生产者
 */
@Service
public class MessageProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    @Value("${demo.rocketmq.topic}")
    private String topic;

    public SendResult sendMessage(String message) {
        return rocketMQTemplate.syncSend(topic, message);
    }

}
