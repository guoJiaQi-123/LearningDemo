package com.itbaizhan.springbootdemo5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Springbootdemo5Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootdemo5Application.class, args);
    }

}
