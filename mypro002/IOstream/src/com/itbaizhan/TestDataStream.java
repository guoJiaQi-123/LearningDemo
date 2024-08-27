package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/16
 *本类内容：数据流
 */

import java.io.*;

public class TestDataStream {
    public static void main(String[] args) {
        //创建数据输出流对象与文件字节输出流对象
        try(DataOutputStream dos =new DataOutputStream(new FileOutputStream("d:/data"));
            //创建数据输入流对象与文件字节输入流对象
            DataInputStream dis = new DataInputStream(new FileInputStream("d:/data"))){
            //将如下数据写入到文件中
            dos.writeInt(9);
            dos.writeBoolean(true);
            dos.writeChar('c');
            dos.writeDouble(Math.random());
            dos.writeUTF("北京尚学堂");
            dos.flush();//手动刷新缓冲区：将流中数据写入到文件中
            //直接读取数据：读取的顺序要与写入的顺序一致，否则不能正确读取数据。
            System.out.println("int:"+dis.readInt());
            System.out.println("boolean:"+dis.readBoolean());
            System.out.println("char:"+dis.readChar());
            System.out.println("double:"+dis.readDouble());
            System.out.println("String:"+dis.readUTF());

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
