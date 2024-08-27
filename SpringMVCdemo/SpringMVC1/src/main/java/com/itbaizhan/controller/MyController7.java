package com.itbaizhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/c7")
public class MyController7 {

    @PutMapping("/put")
    public String testPut() {
        System.out.println("修改方法");
        return "helloGJQ";
    }

    @DeleteMapping("/delete")
    public String testDelete() {
        System.out.println("删除方法");
        return "helloGJQ";
    }

}
