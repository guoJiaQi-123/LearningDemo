package com.itbaizhan.TestInterface;

public class TestMultipleInheritance {
    public static void main(String[] args) {
        C c=new CImpl01();
        c.a();
        c.b();
        c.c();
    }
}
interface A{
    void a();
}
interface B{
    void b();
}
interface C extends A,B{
    void c();
}
class CImpl01 implements C{

    @Override
    public void a() {
        System.out.println("CImpl01.a");
    }

    @Override
    public void b() {
        System.out.println("CImpl01.b");
    }

    @Override
    public void c() {
        System.out.println("CImpl01.c");
    }
}