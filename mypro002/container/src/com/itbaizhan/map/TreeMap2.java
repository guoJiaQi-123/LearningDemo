package com.itbaizhan.map;/*
 *作者：郭家旗
 *时间：2023/09/10
 *本类内容：利用外部比较器
 */

import com.itbaizhan.set.Student;
import com.itbaizhan.set.StudentComparator;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap2 {

    public static void main(String[] args) {

        Map<Student,String> map =new TreeMap<>(new StudentComparator());

        Student student=new Student("gjq",20);
        Student student1=new Student("shr",19);
        Student student2=new Student("wxw",20);

        map.put(student,student.getName());
        map.put(student1,student1.getName());
        map.put(student2,student2.getName());

        Set<Student> keySet = map.keySet();
        for (Student key:keySet){
            System.out.println(key+"--"+map.get(key));
        }
    }
}
