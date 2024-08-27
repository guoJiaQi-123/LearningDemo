package com.itbaizhan.oop;
/*
   *测试继承
 */
public class TestExtends {
    public static void main(String[] args) {
        Student s1 = new Student(175,"郭家旗","软件工程");
        s1.study();
        System.out.println(s1 instanceof Student);
        System.out.println(s1 instanceof Person);
    }
}
class Person extends Object{  //人类
    String name;
    int height;
    public void rest(){
        System.out.println("休息一下吧！！");
    }
}

class Student extends Person{  //学生类  继承人类
    String major;
    public void study(){
        System.out.println("学习一会儿吧！");
        rest();
        System.out.println(this.name);
    }

public Student(int height,String name,String major){ //构造器
        this.name=name;
        this.height=height;
        this.major=major;
}
}