package com.itbaizhan;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * Hello world!
 *  主启动类
 */
@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class,args);
        log.info("******************* 认证系统启动成功 ******************");
    }
}
