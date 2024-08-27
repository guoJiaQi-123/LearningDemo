package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/16
 *本类内容：对象流实现基本数据类型的输出与输入
 */

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.*;

public class TestObjectSteamBasicType {
    public static void main(String[] args) {
        //创建对象输出流对象与文件字节输出流对象
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("d:/object"))
            //创建对象输入流对象与文件字节输入流对象
            ; ObjectInputStream ois =new ObjectInputStream(new FileInputStream("d:/object"))){
            //将如下数据写入到文件中
            oos.writeBoolean(true);
            oos.writeInt(9);
            oos.writeDouble(Math.random());
            oos.writeUTF("郭家旗！牛逼");
            oos.writeChar('G');
            oos.flush();
            //必须要按照写入的顺序读取数据
            System.out.println("Boolean:"+ois.readBoolean());
            System.out.println("Int:"+ois.readInt());
            System.out.println("Double:"+ois.readDouble());
            System.out.println("String:"+ois.readUTF());
            System.out.println("Char:"+ois.readChar());

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
