package com.itbaizhan;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetBaseInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext servletContext = this.getServletContext();
        //获取容器的基本信息
        String serverInfo = servletContext.getServerInfo();
        //获取容器所支持的主版本号
        int majorVersion = servletContext.getMajorVersion();
        //获取容器所支持的副版本号
        int minorVersion = servletContext.getMinorVersion();
        //设置响应编码
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println("容器的基本信息："+serverInfo);
        pw.println("容器所支持Servlet的版本号为："+majorVersion+"."+minorVersion);

        String s1 = (String) servletContext.getAttribute("key1");
        String s2 = (String)servletContext.getAttribute("key2");
        pw.println(s1);
        pw.println(s2);
        pw.flush();
        pw.close();
    }
}
