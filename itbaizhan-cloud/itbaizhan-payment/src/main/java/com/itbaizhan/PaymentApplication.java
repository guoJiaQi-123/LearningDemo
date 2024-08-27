package com.itbaizhan;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * springboot项目主启动类
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient // 向注册中心注册该服务，并可以获取其他服务的调用地址
public class PaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
        log.info("******************* 支付微服务启动成功 *******************");
    }
}
