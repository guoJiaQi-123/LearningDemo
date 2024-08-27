package com.itbaizhan;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.Log;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.itbaizhan.mapper")
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
        log.info("*********************用户服务生产者工程启动成功*********************");
    }

}
