package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/03
 *本类内容：测试检查时异常(CheckException)已检查异常，编译器会报错   异常的处理方式之一：捕获异常

 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test02 {

    public static void main(String[] args){
        FileReader reader=null;
        try {
            reader = new FileReader("d:/a.txt");
            char c = (char)reader.read();
            char c1 = (char)reader.read();
            char c2 = (char)reader.read();
            System.out.println(""+c+c1+c2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(reader!=null){
                    reader.close();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
