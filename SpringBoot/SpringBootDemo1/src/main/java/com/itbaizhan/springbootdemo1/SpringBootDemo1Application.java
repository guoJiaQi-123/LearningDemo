package com.itbaizhan.springbootdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //SpringBoot启动时扫描注册注解标注的Web组件
public class SpringBootDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemo1Application.class, args);
    }

}
