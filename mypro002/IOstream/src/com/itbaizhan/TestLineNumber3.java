package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/15
 *本类内容：通过字符输出流进行添加行号
 */

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TestLineNumber3 {
    public static void main(String[] args) {
        try(  //创建字符输入缓冲流对象与文件字符输入流对象
                BufferedReader br =new BufferedReader(new FileReader("d:/郭家旗.txt"));
            //创建字符输出流对象
            PrintWriter pw =new PrintWriter("d:/郭家旗4.txt")){
            //操作流
            String str ="";
            int i=1;//定义序号变量
            while ((str=br.readLine())!=null){
                pw.println(i+":"+str);
                i++;//序号累加
            }
            pw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
