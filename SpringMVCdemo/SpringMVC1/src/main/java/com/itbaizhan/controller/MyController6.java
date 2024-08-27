package com.itbaizhan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c6")
public class MyController6 {

    @ModelAttribute
    public void before(Model model) {
        model.addAttribute("name","郭家旗");
    }

    @RequestMapping("/t1")
    public String t1(@ModelAttribute("name") String name){
        System.out.println(name);
        return "helloGJQ";
    }
}
