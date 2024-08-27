package com.tyut.pattern._01_creative_model.e01singleton.demo8;

import java.io.*;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 测试类 - 测试序列化/反序列化会不会破坏单例模式
 */
public class Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        writeObjToFile();
        readObjFromFile();
        readObjFromFile();
    }

    public static void readObjFromFile() throws IOException, ClassNotFoundException {
        // 1.创建对象输入流对象
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\HX\\Desktop\\Typora笔记存放\\a.txt"));
        // 2.读取对象
        Singleton singleton = (Singleton) objectInputStream.readObject();
        System.out.println(singleton); // 输出的地址不一样，说明：序列化/反序列化会破坏单例模式
        // 3.关闭资源
        objectInputStream.close();
    }

    /**
     * 序列化对象，写道磁盘文件中
     * @throws IOException io异常
     */
    public static void writeObjToFile() throws IOException {
        // 1.创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\HX\\Desktop\\Typora笔记存放\\a.txt"));
        // 2.创建对象
        Singleton instance = Singleton.getInstance();
        // 3.对外写出对象
        oos.writeObject(instance);
        // 4.关闭资源
        oos.close();
    }

}
