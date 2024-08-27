package com.itbaizhan;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class GetConfigServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletConfig对象
        ServletConfig servletConfig = this.getServletConfig();
        //获取<servlet>标签下的<init-param>中的所有的key
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        PrintWriter pw = resp.getWriter();
        while (initParameterNames.hasMoreElements()){
            String key = initParameterNames.nextElement();
            //根据key获取对应的value
            String value = servletConfig.getInitParameter(key);
            pw.println("key: " + key+" value: "+value);
        }
        pw.flush();
        pw.close();
    }
}
