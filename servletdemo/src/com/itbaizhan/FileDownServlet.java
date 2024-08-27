package com.itbaizhan;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件下载
 */
public class FileDownServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext servletContext = this.getServletContext();
        String path =(String) servletContext.getAttribute("path");

        //转换路径
        String realPath = servletContext.getRealPath(path+"\\图灵院第二月详细安排（强烈建议看回放）.PNG");
        File file=new File(realPath);
        InputStream is=new FileInputStream(file);
        byte[] buff=new byte[is.available()];
        is.read(buff);

        //在响应中添加附加信息
        resp.addHeader("Content-Disposition","attachment;filename="+new String(file.getName().getBytes("gbk"),"iso-8859-1"));

        //产生响应
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(buff);
        outputStream.flush();
        outputStream.close();
    }
}
