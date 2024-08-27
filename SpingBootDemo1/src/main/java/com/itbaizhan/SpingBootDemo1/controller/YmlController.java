package com.itbaizhan.SpingBootDemo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class YmlController {

    @Value("${name}")
    private String name;

    @Value("${city1[0]}")
    private String city;

    @Value("${students[2].age}")
    private int age;

    @Value("${student2.sex}")
    private String sex;

    @RequestMapping("/yml")
    @ResponseBody
    public String yml(){
        System.out.println(name);
        System.out.println(city);
        System.out.println(age);
        System.out.println(sex);
        return "hello springboot!";
    }
}
