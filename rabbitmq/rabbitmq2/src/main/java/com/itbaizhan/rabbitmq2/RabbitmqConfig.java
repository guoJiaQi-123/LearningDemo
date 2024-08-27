package com.itbaizhan.rabbitmq2;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("all")
public class RabbitmqConfig {
    private final String EXCHANGE_NAME = "boot_exchange_topic";
    private final String QUEUE_NAME = "boot_queue";

    //创建交换机
    @Bean(name = "bootExchange")
    public Exchange getExchange() {
        return ExchangeBuilder
                .topicExchange(EXCHANGE_NAME)//交换机类型和名字
                .durable(true)//交换机是否持久化
                .build();
    }

    //创建队列
    @Bean(name = "bootQueue")
    public Queue getQueue() {
        return new Queue(QUEUE_NAME);//队列名
    }

    //绑定交换机和队列
    @Bean
    public Binding binding(
                            @Qualifier("bootExchange") Exchange exchange,
                            @Qualifier("bootQueue") Queue queue) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with("#.message.#")
                .noargs();
    }

}
