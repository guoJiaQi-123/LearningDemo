package com.itbaizhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController2 {
    @RequestMapping("/t2")
    public String t2(){
        String s = null;
        s.length();
        return "index";
    }


}
