package com.itbaizhan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 创建HttpSession对象
 */
public class CreatHttpSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建HttpSession对象
        HttpSession httpSession = req.getSession();

        String header = req.getHeader("User-Agent");
        if(header.indexOf("Chrome")!=-1){
            //向Session对象中赋值
            httpSession.setAttribute("key","Chrome");
        }else {
            httpSession.setAttribute("key","IE");
        }
        System.out.println(httpSession);
        //获取Session对象的地址
        String id = httpSession.getId();
        PrintWriter pw = resp.getWriter();
        pw.println("creat session ok!"+id);
        pw.flush();
        pw.close();
    }
}
