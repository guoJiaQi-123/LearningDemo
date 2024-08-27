package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/15
 *本类内容：文件字符输入流
 */

import java.io.FileReader;
import java.io.IOException;

public class TestFailReader {
    public static void main(String[] args) {
        //创建一个文件字符输入流
        try (FileReader fr=new FileReader("d:/b.txt")){
            int item =0;
            StringBuilder sb = new StringBuilder();
            while ((item=fr.read())!=-1){
                sb.append((char) item);
            }
            System.out.println(sb);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
