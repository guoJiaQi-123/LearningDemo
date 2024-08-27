package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/14
 *本类内容：新语法的经典写法
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test3 {
    public static void main(String[] args) {
        try(FileInputStream fis =new FileInputStream("d:/b.txt")) {
            StringBuilder sb =new StringBuilder();
            int item=0;
            while ((item = fis.read())!=-1){
                sb.append((char) item);
            }
            System.out.println(sb);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
