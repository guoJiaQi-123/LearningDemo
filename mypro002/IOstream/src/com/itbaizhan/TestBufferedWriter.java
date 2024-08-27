package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/15
 *本类内容：字符输出缓冲流
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestBufferedWriter {
    public static void main(String[] args) {
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("d:/郭家旗.txt"))){
            bw.write("郭家旗牛逼");
            bw.write("！！！！");
            bw.newLine();
            bw.write("牛逼牛逼");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
