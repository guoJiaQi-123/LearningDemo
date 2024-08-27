package com.tyut.pattern._01_creative_model.e03prototype.demo3;

import org.apache.commons.lang3.SerializationUtils;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote 客户端 - 测试类 测试浅拷贝
 */
public class CitationTest2 {

    public static void main(String[] args) throws CloneNotSupportedException {

        Citation citation = new Citation();
        Student student = new Student();
        student.setName("张三");
        citation.setStudent(student);

//        Citation cloned = citation.clone();
//        Student student1 = cloned.getStudent();
//        student1.setName("李四");
//
//        citation.show();
//        cloned.show();
        Citation cloned = SerializationUtils.clone(citation);
        System.out.println(citation==cloned);
        System.out.println(citation.getStudent()==cloned.getStudent());
        Student student1 = new Student();
        student1.setName("李四");
        cloned.setStudent(student1);
        System.out.println(citation.getStudent().getName());
        System.out.println(cloned.getStudent().getName());

    }

}
