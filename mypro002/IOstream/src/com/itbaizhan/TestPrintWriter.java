package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/15
 *本类内容：字符输出流对象
 */

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TestPrintWriter {
    public static void main(String[] args) {
        try(PrintWriter pw =new PrintWriter("d:郭家旗5.txt")){
            pw.print("郭家旗牛逼");
            pw.print("!!!");
            pw.println("nbnb");
            pw.println("nbkls");
            pw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
