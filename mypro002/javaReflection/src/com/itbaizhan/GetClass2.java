package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/27
 *本类内容：**通过forName()获取Class对象**
 */

public class GetClass2 {
    public static void main(String[] args) {
        try {
            Class aClass = Class.forName("com.itbaizhan.Users");
            Class<?> aClass1 = Class.forName("com.itbaizhan.Users");
            System.out.println(aClass);
            System.out.println(aClass.getName());

            System.out.println(aClass1==aClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
