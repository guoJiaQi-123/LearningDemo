package com.itbaizhan;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AutoStartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw=resp.getWriter();
        pw.println("AutoStartServlet.............");
        pw.flush();
        pw.close();
    }

    @Override
    public void init() throws ServletException {
        System.out.println("AutoStartServlet init.............");
        //通过Servlet自启动读取配置文件中的信息
        ServletConfig servletConfig = this.getServletConfig();
        String value = servletConfig.getInitParameter("path");
        //存放到全局容器中
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("path",value);
    }
}
