package com.itbaizhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    // 忽略访问项目logo
    @RequestMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {}

}
