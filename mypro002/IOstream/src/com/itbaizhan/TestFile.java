package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/16
 *本类内容：File类在IO中的作用
 */

import java.io.*;

public class TestFile {
    public static void main(String[] args) {
        //创建字符缓冲流与文件字符输入流对象
        try(BufferedReader br=new BufferedReader(new FileReader(new File("d:/郭家旗.txt")));
            //创建字符输出流对象
            PrintWriter pw =new PrintWriter(new File("d:/郭家旗9.txt"))){
            //操作流
            String str ="";
            int i =1;
            while ((str=br.readLine())!=null){
                pw.println(i+":"+str);
                i++;
            }
            pw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
