package com.itbaizhan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 重定向响应案例
 *需求：创建一个搜索页面，通过百度搜索引擎完成内容搜索。
 */
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("utf-8");
        //获取请求信息
        String search = req.getParameter("search");

        resp.sendRedirect("https://www.baidu.com/s?wd="+ URLEncoder.encode(search,"utf-8"));//通过改变编码方式解决中文乱码问题

    }
}
