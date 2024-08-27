package com.itbaizhan.oop.encapsulasion.b;

import com.itbaizhan.oop.encapsulasion.a.Person;

public class Boy extends Person{
    public void play(){
        System.out.println(super.TestProtected);
        System.out.println(super.TestPublic);
        System.out.println(super.TestProtected);
        Person p = new Person();
        //System.out.println(p.TestProtected); // 报错
        //若子类和父类不在同一个包中，子类可访问父类的protected成员，不能访问父类对象的protected成员。
    }
/*【注】关于protected的两个细节：

若父类和子类在同一个包中，子类可访问父类的protected成员,也可访问父类对象的protected成员。
若子类和父类不在同一个包中，子类可访问父类的protected成员，不能访问父类对象的protected成员。*/
}
