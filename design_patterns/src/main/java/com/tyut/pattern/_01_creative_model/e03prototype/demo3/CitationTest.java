package com.tyut.pattern._01_creative_model.e03prototype.demo3;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote 客户端 - 测试深拷贝
 */
public class CitationTest {

    public static void main(String[] args) throws Exception {

//        Citation citation = new Citation();
//        Student student = new Student();
//        student.setName("张三");
//        citation.setStudent(student);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\a.txt"));
//        objectOutputStream.writeObject(citation);
//        objectOutputStream.close();
//
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\a.txt"));
//        Citation citation1 = (Citation) objectInputStream.readObject();
//        Student student1 = citation1.getStudent();
//        student1.setName("李四");
//
//        citation.show();
//        citation1.show();
        Citation citation = new Citation();
        citation.setStudent(new Student());
        String jsonString = JSON.toJSONString(citation);
        Citation newCitation = JSON.parseObject(jsonString, Citation.class);
        System.out.println(citation == newCitation);
        System.out.println(citation.getStudent() == newCitation.getStudent());

    }

}
