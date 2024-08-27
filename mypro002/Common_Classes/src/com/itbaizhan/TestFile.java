package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/05
 *本类内容：
 */

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {

    public static void main(String[] args) throws IOException {
        //获取当前路径
        System.out.println(System.getProperty("user.dir"));

        //创建文件
        File file =new File("a.txt");   //相对路径：默认放到user.dir目录下面
        file.createNewFile();

        File file1 =new File("d:/b.txt"); //绝对路径
        file1.createNewFile();


        System.out.println("文件是否存在"+file1.exists());
        System.out.println("是否是目录"+file1.isDirectory());
        System.out.println("是否是文件"+file1.isFile());
        System.out.println("文件最后的修改时间："+new Date(file1.lastModified()));
        System.out.println("文件的大小"+file1.length());
        System.out.println("文件名"+file1.getName());
        System.out.println("文件的路径"+file1.getAbsolutePath());

        File file2 =new File("d:/电影/华语/成龙");
        boolean b =file2.mkdirs();
        System.out.println(b);
    }
}
