package com.itbaizhan.servlet;

import com.itbaizhan.pojo.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/findUsers2.do")
public class FindUsers2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建Users对象
        Users users1=new Users(1,"zhangsan");
        Users users2=new Users(2,"lisi");
        //实例化Map容器
        Map<String,Users> map = new HashMap<>();
        map.put("users1",users1);
        map.put("users2",users2);

        //将Map传入到Request对象中
        req.setAttribute("map",map);
        //通过请求转发的方式调用JSP渲染页面
        req.getRequestDispatcher("showUser2.jsp").forward(req,resp);
    }
}
