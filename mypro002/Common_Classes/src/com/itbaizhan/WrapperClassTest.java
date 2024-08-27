package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/03
 *本类内容：常用类测试
 */

public class WrapperClassTest {

    void TestInteger(){

        // 基本类型转化成Integer对象
        Integer i = new Integer(10);    //jdk9以后，不建议使用
        Integer j =Integer.valueOf(50);

        // Integer对象转化成int
        int a=i.intValue();

        // 字符串转化成Integer对象
        Integer i1=Integer.parseInt("854");
        Integer i2=new Integer("123");

        //Integer i2=new Integer("546asda");     //报错NumberFormatException
        // Integer对象转化成字符串
        String s = j.toString();

        // 一些常见int类型相关的常量
        System.out.println(Integer.MAX_VALUE);   //int 类型的最大值

        //自动装箱
        Integer x =100;                          //本质上：Integer x =Integer.valueOf(100);

        //自动拆箱
        int y = x;                                //本质上：int y=x.intValue();


    }

    public static void main(String[] args) {
        WrapperClassTest a = new WrapperClassTest();
        a.TestInteger();
        //测试缓存  自动装箱时[-127,128]之间有缓存 不new新的对象
        Integer x1 = 100;
        Integer x2 = 100;
        Integer x3 = 1000;
        Integer x4 = 1000;
        System.out.println(x1==x2);
        System.out.println(x1.equals(x2));  //equals比较的是value
        System.out.println(x3==x4);
        System.out.println(x3.equals(x4));
    }

}
