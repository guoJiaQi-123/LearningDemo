package com.itbaizhan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * Hello world!
 *
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient // nacos 服务注册
public class PaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
        log.info("******************** 支付服务启动成功 ***************");
    }
}
