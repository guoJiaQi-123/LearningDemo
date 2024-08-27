package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/14
 *本类内容：经典IO流程序
 */

import java.io.FileInputStream;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) {
        //创建一个输入流对象
        FileInputStream fileInputStream = null;
        try {
            fileInputStream =new FileInputStream("d:/b.txt");
            int i=0;
            StringBuilder stringBuilder =new StringBuilder();
            while ((i=fileInputStream.read())!=-1){
                stringBuilder.append((char) i);
            }
            System.out.println(stringBuilder);
        }catch (Exception e){
            e.printStackTrace();
        }finally {

                try {
                    if(fileInputStream!=null){
                    fileInputStream.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

        }
    }
}
