package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/06
 *本类内容：泛型方法
 */

public class MethodGeneric {

    //定义一个可变参数的泛型方法
    public <T> void method(T ... args){
        for (T t:args){
            System.out.println(t);
        }
    }

    //定义一个无返回值类型的泛型方法
    public <T> void setName(T name){
        System.out.println(name);
    }

    //定义一个有返回值类型的泛型方法
    public <T> T getAge(T age){
        return age;
    }


}
