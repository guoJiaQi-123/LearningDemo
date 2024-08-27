package com.itbaizhan;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

public class CreatCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一个Cookie对象
        Cookie cookie = new Cookie(URLEncoder.encode("尚学堂","utf-8"),URLEncoder.encode("百战程序员","utf-8"));
        //将Cookie设置为持久化Cookie，时间为60s
        cookie.setMaxAge(60);
        //将创建的Cookie对象响应给客户端
        resp.addCookie(cookie);

        PrintWriter pw = resp.getWriter();
        pw.println("creat cookie OK");
        pw.flush();
        pw.close();
    }
}
