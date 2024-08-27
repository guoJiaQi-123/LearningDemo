package com.tyutgjq.web_cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;


@Slf4j
@SpringBootApplication
public class WebCacheApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebCacheApplication.class, args);
        log.info("*******************服务启动*******************");
    }

}
