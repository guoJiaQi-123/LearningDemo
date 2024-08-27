package com.tyutgjq;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
class FastdfsdemoApplicationTests {

    @Test
    void contextLoads() {
    }


    //fastdfs存储节点的客户端对象
    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    /**
     * 测试springboot环境下的javaAPI对分布式文件系统的上传文件的操作
     */
    @Test
    void testUpLoadFile() throws IOException {
        //1.创建文件
        File file = new File("C:\\Users\\HX\\Desktop\\20200629191804_ttebh.jpg");
        //2.创建文件流
        FileInputStream fileInputStream = new FileInputStream(file);
        //3.上传文件
        /**
         * 参数一：文件输入流
         * 参数二：文件长度
         * 参数三：文件类型
         * 参数四：描述文件的元数据
         * 返回值：上传文件在存储节点的唯一标识（卷名 + 文件路径）
         */
        StorePath storePath = fastFileStorageClient.uploadFile(fileInputStream, file.length(), "jpg", null);
        //4.打印上传文件在fdfs中的路径
        System.out.println(storePath.getFullPath());//卷名加路径
        System.out.println(storePath.getGroup());//获取卷名
        System.out.println(storePath.getPath());//获取路径
        //5.关闭流对象
        fileInputStream.close();
    }

    @Test
    void testDownLoad() throws IOException {
        //1.从fdfs节点中下载资源到本地（为一个字节数组）
        /**
         * 参数一：文件在fdfs节点中的卷名
         * 参数二：文件在fdfs节点中的文件名
         * 参数三：回调函数
         * 返回值：文件内容的字节数组
         */
        byte[] bytes = fastFileStorageClient.downloadFile("group1", "M00/00/00/wKhClmW1uyKAbDsWAAFDLX1G8pw344.jpg", new DownloadByteArray());
        //创建文件输出流，指定输出位置及文件名
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\HX\\Desktop\\test测试下载.jpg");
        //3.通过文件的字节输出流将下载下来的字节数组写为本地文件
        fileOutputStream.write(bytes);
        //4.刷新
        fileOutputStream.flush();
        //5.关闭流对象
        fileOutputStream.close();
    }

}
