package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/15
 *本类内容：文件字符输出流
 */

import java.io.FileWriter;
import java.io.IOException;

public class TestFailWrite {
    public static void main(String[] args) {
        //创建文件字符输出流对象
        try(FileWriter fw = new FileWriter("d:/b.txt",true)){
            fw.write("爱苏苏\r\n");
            fw.write("爱苏苏\r\n");
            fw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
