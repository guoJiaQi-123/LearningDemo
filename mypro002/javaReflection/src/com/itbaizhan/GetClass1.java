package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/25
 *本类内容：反射：通过getClass()方法获取Class对象
 */

public class GetClass1 {
    public static void main(String[] args) {
        //实例化Users对象
        Users users = new Users();
        //因为getClass()方法是Object类下的非静态方法，他会返回当前对象的一个类对象
        Class usersClass = users.getClass();
        System.out.println(usersClass);
        System.out.println(usersClass.getName());
        Users users1=new Users();
        System.out.println(users.getClass() == users1.getClass());
    }
}
