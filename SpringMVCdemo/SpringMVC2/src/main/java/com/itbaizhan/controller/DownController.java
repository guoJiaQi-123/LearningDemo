package com.itbaizhan.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class DownController {

    //显示文件
    @RequestMapping("/download")
    public String download(HttpServletRequest request, Model model){
        //1.获取下载文件路径集合。注：跨服务器上传中，网络路径无法获取文件列表。
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        File file = new File(realPath);
        String[] fileList = file.list();
        //2.将路径放入模型中，跳转到JSP页面
        model.addAttribute("files",fileList);
        return "download";
    }

    //下载文件
    @RequestMapping("/down")
    public void down(HttpServletRequest request, HttpServletResponse response,String fileName) throws IOException {
        //设置文件下载响应头
        response.setHeader("Content-Disposition", "attachment; filename="+fileName);
        //获取文件路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        //通过文件路径和文件名获取指定文件
        File file = new File(realPath,fileName);
        //获取字节输出流
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(FileUtils.readFileToByteArray(file));
        outputStream.flush();
        outputStream.close();
    }
}
