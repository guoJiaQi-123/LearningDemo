package com.itbaizhan.oop;
/*
*         测试super
*   */
public class TestSuper01 {
    public static void main(String[] args) {
        new ChildClass().f();   //调用子类中的f方法
    }
}
class FatherClass{  // 父类
    int value;
    public void f(){
        value=100;
        System.out.println("FatherClass.value="+value);
    }
}
class ChildClass extends FatherClass{   //子类.继承父类
    int value;
    int age;
    public void f(){
        super.f();    //通过super在子类里面可以调用父类的一些属性和方法
        value=200;
        System.out.println("ChildClass="+value);
        System.out.println(value);
        System.out.println(super.value);
    }
    public void f2(){
        System.out.println(age);
    }
}