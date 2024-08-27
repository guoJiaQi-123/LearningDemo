package com.itbaizhan.myshiro.listener;

import org.apache.shiro.session.Session;
import org.springframework.stereotype.Component;

@Component
public class MySessionListener implements org.apache.shiro.session.SessionListener {

    //会话创建监听器
    @Override
    public void onStart(Session session) {
        System.out.println("会话创建："+session.getId());
    }


    //会话停止/结束监听器
    @Override
    public void onStop(Session session) {
        System.out.println("会话停止："+session.getId());
    }


    //会话结束监听器
    @Override
    public void onExpiration(Session session) {
        System.out.println("会话结束："+session.getId());
    }
}
