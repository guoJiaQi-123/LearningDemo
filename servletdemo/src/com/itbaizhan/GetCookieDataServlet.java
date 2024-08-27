package com.itbaizhan;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * 获取Cookie中的数据
 */
public class GetCookieDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        for(int i=0;i<cookies.length;i++){
            Cookie cookie = cookies[i];
            String name = cookie.getName();
            String value = cookie.getValue();
            pw.println("Name: "+ URLDecoder.decode(name,"utf-8") +" Value:"+URLDecoder.decode(value,"utf-8"));
        }
        pw.flush();
        pw.close();
    }


}
