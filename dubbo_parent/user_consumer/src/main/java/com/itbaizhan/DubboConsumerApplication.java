package com.itbaizhan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class DubboConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(DubboConsumerApplication.class, args);
        log.info("**********************用户消费者工程启动成功**********************");
    }

}
