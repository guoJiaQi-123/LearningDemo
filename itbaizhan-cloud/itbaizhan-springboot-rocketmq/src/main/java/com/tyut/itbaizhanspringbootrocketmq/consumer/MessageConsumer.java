package com.tyut.itbaizhanspringbootrocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @version v1.0
 * @author OldGj 2024/5/3
 * @apiNote 消息消费者
 */
@Service
@RocketMQMessageListener(
        // 消费者组
        consumerGroup = "${demo.rocketmq.consumer.group}",
        // 消费的主题
        topic = "${demo.rocketmq.topic}",
        selectorType = SelectorType.TAG,
        selectorExpression = "a"
)
public class MessageConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        // 消费消息
        System.out.println(message + "123");
    }
}
