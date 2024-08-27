package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/12
 *本类内容：第一个IO程序
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class test1 {
    public static void main(String[] args) {
        try {  //创建输入流
            FileInputStream fileInputStream=new FileInputStream("d:/b.txt");//文件内容是：abc
            int read = fileInputStream.read();  //一个字节一个字节的读取数据
            int read1 = fileInputStream.read();
            int read2 = fileInputStream.read();
            int read3 = fileInputStream.read();
            System.out.println(read);
            System.out.println(read1);
            System.out.println(read2);
            System.out.println(read3);//// 由于文件内容已经读取完毕，返回-1
            // 流对象使用完，必须关闭！不然，总占用系统资源，最终会造成系统崩溃！
            fileInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
