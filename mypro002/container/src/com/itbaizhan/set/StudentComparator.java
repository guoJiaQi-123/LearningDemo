package com.itbaizhan.set;/*
 *作者：郭家旗
 *时间：2023/09/09
 *本类内容：Student类的外部比较器
 */

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {//外部比较器重写Comparator接口的compare方法
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge()>o2.getAge()){
            return 1;
        }
        if(o1.getAge()==o2.getAge()){
            return o1.getName().compareTo(o2.getName());
        }
        return -1;
    }
}
