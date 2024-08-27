package com.itbaizhan.oop.encapsulasion.a;

public class Student extends Person{
    public  void study(){
        System.out.println(super.TestDefault);
        Person p = new Person();
        System.out.println(p.TestDefault);
        System.out.println(p.TestProtected);
        System.out.println(p.TestPublic);
    }
}
