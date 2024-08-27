package com.itbaizhan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class GetRequestHeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据key获取请求头中的value
        String value = req.getHeader("Accept-Encoding");

        //获取请求头中的所有的key
        Enumeration<String> headerNames = req.getHeaderNames();



        PrintWriter pw = resp.getWriter();
        pw.println("Accept-Encoding :"+value);
        while (headerNames.hasMoreElements()){//遍历枚举类型获取每一个key
            String key = headerNames.nextElement();
            String values = req.getHeader("s");//根据获取的每一个key获取对应value
            pw.println(key+" : "+values);
        }
        pw.flush();
        pw.close();

    }
}
