package com.itbaizhan;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *  主启动类
 */
@SpringBootApplication
@EnableDubbo
@Slf4j
@MapperScan("com.itbaizhan.mapper")
public class PaymentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
        log.info("******************* 支付系统启动成功 *******************");
    }
}
