package com.itbaizhan.polymorphism;

public class Person {
    public void eat(){
        System.out.println("吃吃吃");
    }
}
class Chinese extends Person{
    public void eat(){
        System.out.println("中国人拿筷子吃");
    }
}
class American extends Person{
    public void eat(){
        System.out.println("美国人拿用刀叉吃");
    }
}
