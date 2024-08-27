package com.itbaizhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/c4")
@SessionAttributes("name")
public class MyController4 {

    @RequestMapping("/t1")
    public String t1(Model model){
        model.addAttribute("name","郭家旗");
        return "helloGJQ";
    }

    @RequestMapping("/t2")
    public String t2(HttpSession session){
        System.out.println(session.getAttribute("name"));
        return "helloGJQ";
    }
}
