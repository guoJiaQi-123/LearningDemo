package com.tyut;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * Hello world!
 *
 */
@Slf4j
@SpringBootApplication
@EnableFeignClients  // 远程调用
@EnableDiscoveryClient // 注册服务
public class OrderFeignConsumer {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignConsumer.class, args);
        log.info("******************* 消费者服务启动成功 *******************");
    }
}
