package com.itbaizhan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 产生字节类型响应
 */
public class ResponseByteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //给定读取响应图片的路径
        File file=new File("C:\\Users\\HX\\Desktop\\图灵院项目\\图灵院第二月详细安排（强烈建议看回放）.PNG");
        //创建读取图片的IO流
        InputStream is=new FileInputStream(file);
        //创建字节缓冲区
        byte[] buff=new byte[is.available()];
        //读取响应图片
        is.read(buff);

        //设置响应类型
        resp.setContentType("image/png");
        //产生字节类型响应
        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(buff);
        outputStream.flush();
        outputStream.close();

    }
}
