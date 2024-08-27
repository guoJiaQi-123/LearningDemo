package com.itbaizhan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *需求：当客户端浏览器第一次访问Servlet时响应“您好，欢迎您第一次访问！”
 * ，第二次访问时响应“欢迎您回来！”。
 */
public class WelcomeSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession httpSession = req.getSession(false);
        boolean flag=true;
        if(httpSession==null){
            flag=false;
            req.getSession();
        }
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw=resp.getWriter();
        if(flag){
            pw.println("欢迎您回来！");
        }else {
            pw.println("您好，欢迎您第一次访问！");
        }
    }
}
