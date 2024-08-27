package com.tyut.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @version v1.0
 * @author OldGj 2024/8/21
 * @apiNote OpenFeign 配置
 */
@Configuration
public class OpenFeignLoggerConfig {


    /*
        OpenFeign日志增强
     */
    @Bean
    Logger.Level getFeignLog() {
        return Logger.Level.BASIC;
    }


    /*
        OpenFeign超时重试
     */
    @Bean
    Retryer retryer() {
        /*
         * 参数一：重试间隔
         * 参数二：最大重试间隔
         * 参数三：重试次数
         */
        return new Retryer.Default(1000, 1000, 3);
    }
}
