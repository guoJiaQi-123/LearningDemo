package com.itbaizhan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetRequestInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //获取请求的完整url
        String RequestURL = req.getRequestURL().toString();

        //获取请求的URI
        String requestURI = req.getRequestURI();

        //获取发出请求的客户机的IP地址。
        String clientAddr = req.getRemoteAddr();

        //获取服务端所在的IP地址
        String serverAddr = req.getLocalAddr();

        //获取WEB服务器处理Http协议的连接器所监听的端口。
        int localPort = req.getLocalPort();

        PrintWriter printWriter = resp.getWriter();
        printWriter.println("URL:"+RequestURL);
        printWriter.println("URI:"+requestURI);
        printWriter.println("clientAddr:"+clientAddr);
        printWriter.println("serverAddr:"+serverAddr);
        printWriter.println("localPort:"+localPort);
        printWriter.flush();
        printWriter.close();

    }

}
