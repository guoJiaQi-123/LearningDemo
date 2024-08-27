package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/14
 *本类内容：文件字节缓冲流（处理流）
 */

import java.io.*;

public class TestFileBufferSteam {

    public static void main(String[] args) {
        long time1 =System.currentTimeMillis();
        FileCopy("d:/1.png","d:/4.png");
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
    }
    public static void FileCopy(String resource ,String destination){
             //实例化节点流
        try(FileInputStream fis =new FileInputStream(resource);
            FileOutputStream fos =new FileOutputStream(destination);
            //实例化处理流
            BufferedInputStream bis =new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos)){

            int item =0;
            while ((item=bis.read())!=-1){
                bos.write(item);
            }
            bos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
