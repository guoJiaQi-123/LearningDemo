package com.itbaizhan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version v1.0
 * @author OldGj 2024/04/22
 * @apiNote 测试配置中心是否正常运行
 */
@RestController
@RefreshScope //nacos 配置动态刷新
public class Hello {


    @Value("${hello.message}")
    private String hello;

    @GetMapping("/getHello")
    public String getHello() {
        return hello;
    }

}
