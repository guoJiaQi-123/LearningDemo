package com.tyut.springai01chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringAi01ChatApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringAi01ChatApplication.class, args);
        log.info("******************* 项目启动成功 *******************");

    }

}
