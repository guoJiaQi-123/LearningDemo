package com.itbaizhan.myshiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
    @RequestMapping("/{page}")
    public String pageController(@PathVariable String page){
        return page;
    }



    // 忽略favicon.ico的获取
    @GetMapping("favicon.ico")
    @ResponseBody
    public void noFavicon() {}
}
