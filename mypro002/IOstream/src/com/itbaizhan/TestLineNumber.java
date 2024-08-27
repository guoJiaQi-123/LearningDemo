package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/15
 *本类内容：为文件中的内容添加行号
 */

import java.io.*;

public class TestLineNumber {
    public static <e> void main(String[] args) {
        //创建字符输入缓冲流与文件字符输入流
        try(BufferedReader br =new BufferedReader(new FileReader("d:/b.txt"))
            //创建字符输出缓冲流与文件字符输出流
            ; BufferedWriter bw =new BufferedWriter(new FileWriter("d:/a.txt"))){
            String str ="";
            int i =1;//定义序号变量
            while ((str = br.readLine())!=null){
                //读取文本文件的内容，给每一行内容加行号
                bw.write(i+":"+str);
                //换行操作
                bw.newLine();
                //行号累加
                i++;
            }
            //刷新
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
