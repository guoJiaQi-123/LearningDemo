package com.itbaizhan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 获取请求头案例
 *需求：编写一个Servlet，如果浏览器的语言是zh-CN，显示“你好，聪明的中国人！”，如果浏览器的语言设置为en-US,那么则显示“Hello，American”。
 */
public class LanguageExampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String language = req.getHeader("Accept-Language");

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();

        if(language.startsWith("zh-CN")){
            pw.println("你好，聪明的中国人！");
        }else if(language.startsWith("en-US")){
            pw.println("Hello，American");
        }else {
            pw.println("对不起，我不认识你！！");
        }
        pw.flush();
        pw.close();
    }
}
