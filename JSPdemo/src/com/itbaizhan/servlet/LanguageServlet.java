package com.itbaizhan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在Servlet中获取客户端浏览器所支持的语言，
 * 并通过JSP页面将客户端浏览器所支持的语言响应给客户端浏览器。
 */
@WebServlet("/language.do")
public class LanguageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求头中的信息
        String header = req.getHeader("Accept-Language");
        //将查询到的信息存放到Request对象中
        req.setAttribute("header",header);
        //使用请求转发跳转到JSP做页面渲染
        req.getRequestDispatcher("showMsg.jsp").forward(req,resp);
    }
}
