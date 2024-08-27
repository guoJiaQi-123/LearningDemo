package com.itbaizhan.InnerClass;
/*测试内部类*/
public class Outer {
    private int age=10;

    public void show(){
        System.out.println("Outer.show");
        System.out.println(age);

    }

    public class Inner{
        int age=20;

        public void show(){
            System.out.println("Inner.show");
            System.out.println(age);
            Outer.this.show();
            System.out.println(Outer.this.age);
        }
    }
}
