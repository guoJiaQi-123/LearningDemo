package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/03
 *本类内容：异常的处理方式之二：声明异常（throws子句）
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test03 {

    public static void main(String[] args) throws IOException {
        FileReader reader=null;
        reader =new FileReader("d:/a.txt");
        char c=(char)reader.read();
        System.out.println(""+c);
        if (reader!=null)reader.close();

    }
}
