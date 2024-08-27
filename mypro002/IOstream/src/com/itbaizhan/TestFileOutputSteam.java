package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/14
 *本类内容：文件字节输出流
 */

import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputSteam {
    public static void main(String[] args) {
        // true表示内容会追加到文件末尾；false表示重写整个文件内容。
        try(FileOutputStream fos =new FileOutputStream("d:/b.txt",true);){
            //创建输出的对象
            String s ="郭家旗。";
            //将整个字节数组写入到文件中
            fos.write(s.getBytes());
            //刷新 将数据从内存中写到磁盘上
            fos.flush();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }



    }
}
