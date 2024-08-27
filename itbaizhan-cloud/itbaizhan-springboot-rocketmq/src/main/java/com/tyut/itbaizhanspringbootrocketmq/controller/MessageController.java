package com.tyut.itbaizhanspringbootrocketmq.controller;

import com.tyut.itbaizhanspringbootrocketmq.producer.MessageProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/5/3
 * @apiNote 消息发送控制层
 */
@RestController
public class MessageController {


    @Autowired
    private MessageProducer messageProducer;


    @GetMapping("/send")
    public SendResult send(String message) {
        return messageProducer.sendMessage(message);
    }

}
