package com.itbaizhan.springbootrocketmqproducer.producer;

import com.itbaizhan.springbootrocketmqproducer.SpringbootRocketmqProducerApplication;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
public class Producter {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    void sendMessage() {
        /*
         * 参数一：主题名称 参数二：消息内容
         */
        rocketMQTemplate.convertAndSend("topic_springboot_01", "springboot:hello rocketmq...");
    }



}

