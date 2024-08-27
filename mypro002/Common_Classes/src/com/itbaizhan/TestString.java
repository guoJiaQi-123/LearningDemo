package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/04
 *本类内容：测试字符串相关类的一个使用
 */

public class TestString {

    public static void main(String[] args) {
        //字符串的拼接
        String s = "hello"+"world";
        String s2 = "helloworld";
        System.out.println(s==s2);

        //StringBuilder用法  线程不同步   线程不安全  但效率高
        StringBuilder s1 = new StringBuilder("中国人");
        //append 用法  添加
        System.out.println(s1.append("爱").append("中国").toString());

        //insert 用法 插入
        System.out.println(s1.insert(0,"今天的"));

        //StringBuffer用法  线程同步  线程安全  效率低
        StringBuffer b2 = new StringBuffer("中国");

        //insert 方法  返回自身 连续插入
        System.out.println(b2.insert(0,"好").insert(0,"常").insert(0,"非"));

        //delete  方法  删除下标在[x,y)的字符
        b2.delete(0,3);
        System.out.println(b2);

        //deletecharAt()   删除某个字符
        b2.deleteCharAt(1);
        System.out.println(b2);

        System.out.println(s1.delete(0,3));

        //reverse 方法  字符串逆序
        System.out.println(s1.reverse());
    }
}
