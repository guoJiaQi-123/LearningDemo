package com.tyutgjq.controller;


import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UploadController {


    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @RequestMapping("/upload")
    void upload(MultipartFile file) throws IOException {
        //1.判断文件是否存在
        if(file!=null){
            //2.获取文件名
            String name = file.getOriginalFilename();
            //3.截取文件后缀名
            String fileSuffix = name.substring(name.lastIndexOf(".") + 1);
            //4.上传文件
            StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), fileSuffix, null);
            // TODO：将文件在节点中的唯一存储表示保存在数据库
            System.out.println(storePath.getFullPath());
        }
    }
}
