package com.itbaizhan.oop;
/*
     *测试super
     * super“可以看做”是直接父类对象的引用。可通过super来访问父类中被子类覆盖的方法或属性。

       使用super调用普通方法，语句没有位置限制，可以在子类中随便调用。
*  */
public class TestSuper02 {
    public static void main(String[] args) {
        new ChildClass2();
    }
}
class FatherClass2{
    static {
        System.out.println("静态初始化：FatherClass");
    }
    public FatherClass2(){
        System.out.println("创建父类");
    }
}
class ChildClass2 extends FatherClass2{
    static {
        System.out.println("静态初始化：ChildClass");
    }
    /*在一个类中，若是构造方法的第一行没有调用super(...)或者this(...);
    那么Java默认都会调用super(),含义是调用父类的无参数构造方法。*/
    public ChildClass2(){
        System.out.println("创建子类");
    }
}