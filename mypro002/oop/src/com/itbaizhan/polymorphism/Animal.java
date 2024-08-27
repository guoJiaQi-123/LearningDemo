package com.itbaizhan.polymorphism;

public class Animal {
    public void shout(){
        System.out.println("叫了一声");
    }
}
class dog extends Animal{
    public void shout(){
        System.out.println("汪汪汪");
    }
    public void seeDoor(){
        System.out.println("认真看门中");
    }
}
class cat extends Animal{
    public void shout(){
        System.out.println("喵喵喵");
    }
    public void CatchingMice(){
        System.out.println("抓老鼠中-----");
    }
}