package com.itbaizhan.myproduce1;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitConfig3 {

    private final String EXCHANGE_NAME = "priority_exchange";
    private final String QUEUE_NAME = "priority_queue";

    // 1.创建交换机
    @Bean(name = EXCHANGE_NAME)
    public Exchange getExchange() {
        return ExchangeBuilder
                .topicExchange(EXCHANGE_NAME)// 交换机类型
                .durable(true)// 是否持久化
                .build();
    }

    // 2.创建队列
    @Bean(QUEUE_NAME)
    public Queue getQueue() {
        return QueueBuilder
                .durable(QUEUE_NAME)// 队列持久化
                .maxPriority(10)//设置队列的最大优先级，最大可以设置到255，官网推荐不要超过10，,如果设置太高比较浪费资源
                .build();
    }

    // 3.将队列绑定到交换机
    @Bean
    public Binding getBinding(
                                @Qualifier("priority_queue") Queue queue,
                                @Qualifier("priority_exchange") Exchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("my_routing")
                .noargs();
    }

}
