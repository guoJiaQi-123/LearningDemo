package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/15
 *本类内容：转换流（处理流）
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestInputStreamReader {
    public static void main(String[] args) {
        try(//创建一个文件字节输入流
            FileInputStream fis =new FileInputStream("d:/郭家旗.txt");
            //创建字节到字符的转换流
            InputStreamReader isr =new InputStreamReader(fis)){
            StringBuilder sb=new StringBuilder();
            int item =0;
            while ((item = isr.read())!=-1){
                sb.append((char) item);
            }
            System.out.println(sb);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
