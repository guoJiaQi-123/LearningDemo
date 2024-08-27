package com.tyut.springdataelasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringdataelasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdataelasticsearchApplication.class, args);
        log.info("******************* es入门案例启动成功 *******************");
    }

}
