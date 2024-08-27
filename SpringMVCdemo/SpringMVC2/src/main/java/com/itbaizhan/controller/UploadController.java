package com.itbaizhan.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import jdk.nashorn.internal.runtime.URIUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UploadController {

    @RequestMapping("/upload")
    public String upload(HttpServletRequest request) throws Exception {
        //获取当前session的ServletContext的路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");

        //创建文件夹
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        //创建文件上传工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建文件上传工具
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        //解析请求
        List<FileItem> fileItems = servletFileUpload.parseRequest(request);
        //遍历文件
        for (FileItem fileItem:fileItems){
            //判断是否是表单字段
            if(!fileItem.isFormField()){
                //获取文件名
                String name = fileItem.getName();
                //将文件写入到指定路径
                fileItem.write(new File(file,name));
                //删除文件
                fileItem.delete();
            }
        }
        return "index";
    }


    // MultipartFile参数名必须和JSP文件空间的name属性一致
    @RequestMapping("/upload2")
    public String upload2(HttpServletRequest request, MultipartFile file) throws IOException {
        //获取文件夹的绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        //根据路径创建文件
        File dir = new File(realPath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        // 将上传的数据写到文件夹的文件中

        //获取文件名
        String filename = file.getOriginalFilename();
        //在文件名前随机生成一段id,防止多次上传文件时文件名冲突
        filename = UUID.randomUUID()+"_"+filename;
        //在dir目录下创建一个名字为filename的空文件
        File newFile = new File(dir,filename);
        //将请求体中的数据写入空文件中
        file.transferTo(newFile);


        return "index";
    }

    @RequestMapping("/upload3")
    public String upload3(MultipartFile[] files,String username,HttpServletRequest request) throws IOException {
        System.out.println(username);
        //创建文件夹
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        File dir = new File(realPath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        //遍历文件数组进行多文件上传
        for(MultipartFile file :files){
            String filename = file.getOriginalFilename();
            filename = UUID.randomUUID()+"_"+filename;
            File newFile = new File(dir, filename);
            file.transferTo(newFile);

        }
        return "index";
    }

    @RequestMapping("upload4")
    public @ResponseBody String upload4(HttpServletRequest request,MultipartFile file) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        File dir = new File(realPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        String filename = file.getOriginalFilename();
        filename = UUID.randomUUID()+"_"+filename;
        File newFile = new File(dir, filename);
        file.transferTo(newFile);

        return "/upload/"+filename;
    }

    @RequestMapping("/upload5")
    public @ResponseBody String upload5(MultipartFile file) throws IOException {
        // 设置跨服上传的服务器路径
        String path = "http://localhost:8081/upload/";
        // 获取上传的文件名
        String filename = file.getOriginalFilename();
        filename=UUID.randomUUID()+"_"+filename;
        // 跨服上传：
        // 1.创建客户端对象
        Client client = Client.create();
        // 2.使用客户端对象连接图片服务器
        WebResource resource = client.resource(path+filename);
        // 3.传输数据
        resource.put(file.getBytes());

        return path+filename;
    }
}
