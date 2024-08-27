package com.itbaizhan;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GlobalContainerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext servletContext = this.getServletContext();
        String s1 = (String) servletContext.getAttribute("key1");
        String s2 = (String)servletContext.getAttribute("key2");
        PrintWriter pw=resp.getWriter();
        pw.println(s1);
        pw.println(s2);
        pw.flush();
        pw.close();
    }

    @Override
    public void init() throws ServletException {
        //获取ServletContext对象
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("key1","BJSXT");
        servletContext.setAttribute("key2","ITBZ");
    }
}
