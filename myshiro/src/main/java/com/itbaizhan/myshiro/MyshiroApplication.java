package com.itbaizhan.myshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itbaizhan.myshiro.mapper")
public class MyshiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyshiroApplication.class, args);
    }

}
