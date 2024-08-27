package com.itbaizhan.myproduce1;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitConfig {

    private final String EXCHANGE_NAME = "my_topic_exchange";
    private final String QUEUE_NAME="my_queue";

    // 1.创建交换机
    @Bean(name = "bootExchange")
    public Exchange getExchange(){
        return ExchangeBuilder
                .topicExchange(EXCHANGE_NAME)// 交换机类型
                .durable(true)// 是否持久化
                .build();
    }

    // 2.创建队列
    @Bean(name = "bootQueue")
    public Queue getQueue(){
        return QueueBuilder
                .durable(QUEUE_NAME)// 队列持久化
                .build();
    }

    // 3.将队列绑定到交换机
    @Bean
    public Binding getBinding(
                               @Qualifier("bootQueue")Queue queue,
                               @Qualifier("bootExchange") Exchange exchange){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("my_routing")
                .noargs();
    }

}
