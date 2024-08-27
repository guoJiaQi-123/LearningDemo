package com.itbaizhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/c5")
public class MyController5 {

    @ModelAttribute
    public void t2(){
        System.out.println("前置方法");
    }



    @RequestMapping("/t1")
    public String t1(){
        System.out.println("hello");
        return "helloGJQ";
    }
}
