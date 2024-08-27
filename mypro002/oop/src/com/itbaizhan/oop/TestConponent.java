package com.itbaizhan.oop;
/*
        *测试组合
* */
public class TestConponent {
}
class Person2 extends Object{  //人类
    String name;
    int height;
    public void rest(){
        System.out.println("休息一下吧！！");
    }
}

class Student2 /*extends Person2*/ {  //学生类  继承人类
    String major;
    Person2 person2=new Person2();    //组合   父类的对象当为子类的属性  组合非常灵活，可以加很多类的属性
    public void study() {
        System.out.println("学习一会儿吧！");
        person2.rest();
        System.out.println(this.person2.name);
    }

    public Student2(int height, String name, String major) { //构造器
        this.person2.name = name;
        this.person2.height = height;
        this.major = major;
    }
}