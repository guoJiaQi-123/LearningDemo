package com.bjsxt.annotation;


import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Person {

    @Value("${name}")
    private String name;

    @Value("${password}")
    private String password;




}
