package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/15
 *本类内容：字符输入缓冲流
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestBufferedReader {
    public static void main(String[] args) {
        //创建字符缓冲流和文件字符流
        try(BufferedReader bf=new BufferedReader(new FileReader("d:/b.txt"))){
            //操作字符缓冲流
            String item ="";
            while ((item = bf.readLine())!=null){
                System.out.println(item);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
