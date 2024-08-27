package com.itbaizhan;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/fileUpLoad.do")
@MultipartConfig
public class FileUpLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取文件描述
        String desc = req.getParameter("desc");
        //获取文件
        Part part = req.getPart("file");
        //处理文件名
        String fileNewName = UUID.randomUUID().toString()+part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
        //在文件上传时，通过ServletContext对象进行相对路径转换为绝对路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("image/"+fileNewName);
        System.out.println(realPath);
        //文件保存
        part.write(realPath);

        //给客户端产生一个响应
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println(desc);
        pw.flush();
        pw.close();
    }
}
