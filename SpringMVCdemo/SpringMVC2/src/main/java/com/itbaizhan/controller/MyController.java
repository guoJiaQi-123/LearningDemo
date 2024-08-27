package com.itbaizhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("/t1")
    public String t1(){
        String s = null;
        int i = 5/0;
        return "index";
    }


}
