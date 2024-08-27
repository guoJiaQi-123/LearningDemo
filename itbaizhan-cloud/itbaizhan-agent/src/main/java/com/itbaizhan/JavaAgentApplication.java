package com.itbaizhan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Slf4j
public class JavaAgentApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaAgentApplication.class, args);
        log.info("******************* SUCCESS *******************");
    }
}
