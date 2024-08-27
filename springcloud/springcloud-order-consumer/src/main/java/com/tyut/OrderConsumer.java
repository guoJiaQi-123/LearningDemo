package com.tyut;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Slf4j
public class OrderConsumer {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumer.class, args);
        log.info("******************* 订单服务启动成功 *******************");
    }
}
