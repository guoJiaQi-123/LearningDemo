package com.itbaizhan.myshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionController {

    @RequestMapping("/user/session")
    @ResponseBody
    public void session(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        //获取session id
        System.out.println("会话id:"+session.getId());
        //获取session 本地地址
        System.out.println("会话的主机地址:"+session.getHost());
        //获取session开始时间
        System.out.println("会话开始时间:"+session.getStartTimestamp());
        //获取session结束时间
        System.out.println("会话最后访问时间:"+session.getLastAccessTime());
        //设置session失效时间
        session.setTimeout(1000*60);//毫秒
        // 获取会话过期时间
        System.out.println("会话过期时间:"+session.getTimeout());
        //在session域中设置值
        session.setAttribute("name","guojiaqi");
    }

    @RequestMapping("/user/getSession")
    @ResponseBody
    public void getSession(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        System.out.println(session.getAttribute("name"));
    }
}
