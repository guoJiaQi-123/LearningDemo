package com.itbaizhan;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *  主启动类
 */
@SpringBootApplication
@Slf4j
@EnableDubbo
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
        log.info("******************* 订单系统启动成功 *******************");
    }
}
