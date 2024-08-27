package com.itbaizhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/c4")
public class MyController3 {

    /*
    访问路径为 /c3/annotation1
    支持post和get请求
    请求时必须带有age参数
    请求时必须带有User-agent请求头
   */
    @RequestMapping(value = "/annotation1"
                    ,method = {RequestMethod.POST,RequestMethod.GET},
                    params = {"name"},
                    headers = {"User-agent"})
    public String annotation1(String name){
        System.out.println(name);
        return "helloGJQ";
    }

    @RequestMapping(value = "/annotation2")
    public String annotation2(@RequestParam(name = "name",required = false) String username){
        System.out.println(username);
        return "helloGJQ";
    }

    @RequestMapping("/annotation3")
    public String annotation3(@RequestHeader("User-Agent") String userAgent, @CookieValue("JSESSIONID") String jSessionID){
        System.out.println(userAgent);
        System.out.println(jSessionID);
        return "helloGJQ";
    }
}
