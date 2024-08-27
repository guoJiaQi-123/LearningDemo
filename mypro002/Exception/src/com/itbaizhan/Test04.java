package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/03
 *本类内容：测试    try-with-resource语句
 */

import java.io.FileReader;

public class Test04 {
    public static void main(String[] args) {



        try( FileReader reader =new FileReader("d:/a.txt");){
            char c=(char) reader.read();
            char c1=(char) reader.read();
            char c2=(char) reader.read();
            System.out.println(""+c+c1+c2);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
