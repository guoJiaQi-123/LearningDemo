package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/15
 *本类内容：通过转换流实现键盘输入屏幕输出
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestKeyBoardInput {
    public static void main(String[] args) {
        //             创建字符输入和输出流:使用转换流将字节流转换成字符流
        try(BufferedReader br =new BufferedReader(new InputStreamReader(System.in))
            ; BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out))){
            String str ="";
            while (true){
               bw.write("请输入："); // 写到控制台
               bw.flush();
               str =br.readLine();// 使用字符输入和输出流
               if("quit".equals(str)||"退出程序".equals(str)){  // 一直读取，直到用户输入了exit为止
                   bw.write("bye bye!");
                   break;
               }else {
                   bw.write("您输入的是："+str); // 写到控制台
                   bw.newLine();// 写一行后换行
                   bw.flush();;// 手动刷新
               }
           }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
