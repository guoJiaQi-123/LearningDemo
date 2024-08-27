package com.itbaizhan.set;/*
 *作者：郭家旗
 *时间：2023/09/09
 *本类内容：TreeSet容器通过比较器实现比较规则
 */

import java.util.Set;
import java.util.TreeSet;

public class TreeSet2 {

    public static void main(String[] args) {
        //实例化一个TreeSet容器时将外部比较器添加进来
        Set<Student> set = new TreeSet<>(new StudentComparator());

        //实例化Student对象
        Student student1=new Student("郭家旗",20);
        Student student2=new Student("王旭伟",20);
        Student student3=new Student("苏红润",19);

        //将对象加入到容器中
        set.add(student1);
        set.add(student2);
        set.add(student3);

        for (Student student:set){
            System.out.println(student);
        }
    }
}
