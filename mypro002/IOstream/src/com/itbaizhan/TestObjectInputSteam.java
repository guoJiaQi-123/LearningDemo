package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/16
 *本类内容：
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestObjectInputSteam {
    public static void main(String[] args) {
        //创建对象输入字节流与文件字节输入流对象
        try(ObjectInputStream ois =new ObjectInputStream(new FileInputStream("d:/object1"))){

            Users users = (Users) ois.readObject();//将对象反序列化到内存中
            System.out.println(users);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
