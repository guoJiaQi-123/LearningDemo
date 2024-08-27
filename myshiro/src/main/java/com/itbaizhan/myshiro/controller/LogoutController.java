package com.itbaizhan.myshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
    @RequestMapping("/user/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        // 退出登录
        subject.logout();
        // 退出后跳转到登录页
        return "redirect:login";
    }
}
