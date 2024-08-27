package com.itbaizhan.servlet;

import com.itbaizhan.pojo.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findUser.do")
public class FindUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建Users对象
        Users users1=new Users(1,"zhangsan");
        Users users2=new Users(2,"lisi");
        //实例化List容器
        List<Users> list = new ArrayList<>();
        list.add(users1);
        list.add(users2);

        //将list传入到Request对象中
        req.setAttribute("list",list);
        //通过请求转发的方式调用JSP渲染页面
        req.getRequestDispatcher("showUser.jsp").forward(req,resp);
    }
}
