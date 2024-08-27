package com.itbaizhan.oop.encapsulasion.a;
/*编程中封装的具体优点：

提高代码的安全性。
提高代码的复用性。
“高内聚”：封装细节，便于修改内部代码，提高可维护性。
“低耦合”：简化外部调用，便于调用者使用，便于扩展和协作。*/
public class Person {
    private    int TestPrivate;
               int TestDefault;
    protected  int TestProtected;
    public     int TestPublic;

    public static void main(String[] args) {
        Person p =new Person();
        System.out.println(p.TestPrivate);
        System.out.println(p.TestDefault);
        System.out.println(p.TestProtected);
        System.out.println(p.TestPublic);
    }
}
