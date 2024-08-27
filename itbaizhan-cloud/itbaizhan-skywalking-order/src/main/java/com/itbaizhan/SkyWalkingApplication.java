package com.itbaizhan;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.itbaizhan.mapper")
public class SkyWalkingApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyWalkingApplication.class, args);
        log.info("******************* SUCCESS *******************");
    }
}
