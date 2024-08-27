package com.itbaizhan;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 需求：当客户端浏览器第一次访问Servlet时响应“您好，欢迎您第一次访问！”，第二次访问时响应“欢迎您回来！”。
 */
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取浏览器所返回给客户端的Cookie
        Cookie[] cookies = req.getCookies();
        boolean flag = false;
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if("welcome".equals(cookie.getName())){
                    flag=true;
                }
            }
        }
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        if(flag){
            pw.println("欢迎您回来！");
        }else {
            pw.println("您好，欢迎您第一次访问！");
            Cookie cookie=new Cookie("welcome","welcome");
            cookie.setMaxAge(60);
            resp.addCookie(cookie);
        }
    }
}
