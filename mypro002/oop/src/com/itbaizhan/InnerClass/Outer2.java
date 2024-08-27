package com.itbaizhan.InnerClass;
/*
测试静态内部类
 */
class Outer2{
    private int a = 10;
    private static int b = 20;      //定义一个私有的静态属性
    //相当于外部类的一个静态成员
    static class Inner2{            //静态类
        public void test(){
//          System.out.println(a);  //静态内部类不能访问外部类的普通属性
            System.out.println(b); //静态内部类可以访问外部类的静态属性
        }
    }
}


