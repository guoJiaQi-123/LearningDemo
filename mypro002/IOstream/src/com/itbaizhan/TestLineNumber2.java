package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/15
 *本类内容：通过字节流读取文本文件并添加行号
 */

import java.io.*;

public class TestLineNumber2 {
    public static void main(String[] args) {
        try( //创建字符输入缓冲流、输入字节到字符转换流、文件字节输入流对象
             BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("d:/郭家旗.txt" )));
             //创建字符输出缓冲流、输出字符到字节转换流、文件字节输出流对象
             BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:/郭家旗2.txt")))){
            //操作流
            String str ="";
            int i =1;//序号变量
            while ((str=br.readLine())!=null){ //按照行读取
                bw.write(i+":"+str);
                bw.newLine();//换行
                i++;  //序号累加
            }
            bw.flush();//刷新
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
