package com.bjsxt.web.listener;

import com.bjsxt.commons.Constants;
import com.bjsxt.pojo.Users;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *因为Session对象到达销毁时间会被容器自动销毁，但是存储在上下文对象中的Session对象任然还在，一旦用户在异地登录
 * 会调用原有Session的销毁方法，但是该Session已经被容器自动销毁，所以此时会报错！
 * 解决方法：建立一个Session生命周期监听器，如果这个Session要被容器销毁，则通过监听器先将其从上下文对象中移除，再销毁
 */
@WebListener
public class HttpSessionLifecycleListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //先拿到要销毁的Session对象
        HttpSession httpSession = se.getSession();
        //拿到要销毁的Session对象对应的用户
        Users user = (Users) httpSession.getAttribute(Constants.USER_SESSION_KEY);
        //通过用户ID在上下文对象中将即将要销毁的对象删除
        ServletContext servletContext = httpSession.getServletContext();
        servletContext.removeAttribute(user.getUserid()+"");

    }
}
