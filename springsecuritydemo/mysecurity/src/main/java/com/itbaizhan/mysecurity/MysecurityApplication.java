package com.itbaizhan.mysecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com.itbaizhan.mysecurity.mapper")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MysecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysecurityApplication.class, args);
    }

}
