package com.itbaizhan.paymentdemo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@Slf4j
@SpringBootApplication
@MapperScan("com.itbaizhan.paymentdemo.mapper")
@EnableScheduling // 开启任务调度
public class PaymentDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(PaymentDemoApplication.class, args);
        log.info("log:****************************支付系统启动成功****************************");

    }

}
