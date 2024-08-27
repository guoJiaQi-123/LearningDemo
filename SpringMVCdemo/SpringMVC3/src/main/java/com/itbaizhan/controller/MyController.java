package com.itbaizhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/t1")
    public String t1(Model model){
        model.addAttribute("name","笨蛋");
        model.addAttribute("age",1111);
        return "result";
    }
}
