package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/14
 *本类内容：文件字节输入流
 */

import java.io.FileInputStream;
import java.io.IOException;

public class TestFileInputStream {
    public static void main(String[] args) {
        //使用try-with-resource方式关闭资源。
        //在try中打开资源，不需要在代码中添加finally块关闭资源。
        try(FileInputStream fis =new FileInputStream("d:/b.txt");){
            int item =0;
            StringBuilder sb = new StringBuilder();
            while ((item=fis.read())!=-1){
                sb.append((char) item);
            }
            System.out.println(sb);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
