package com.tyut;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class GatewayMain {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain.class, args);
    }
}
