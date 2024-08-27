package com.tyut;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class CloudPaymentProviderMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudPaymentProviderMain8001.class, args);
        log.info("******************* cloud-payment-provider8001启动成功 *******************");
    }
}
