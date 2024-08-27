package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/16
 *本类内容：将对象序列化到文件


 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestObjectOutputSteam {
    public static void main(String[] args) {
        //创建对象输出字节流与文件输出字节流对象
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("d:/object1"))){
            Users users =new Users();//创建Users对象
            users.setUserage("20");
            users.setUserid(10);
            users.setUsername("gjq");

            oos.writeObject(users); //将对象序列化到文件中
            oos.flush();//刷新
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
