package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/27
 *本类内容：**通过.class 静态属性获取Class对象**
 */

public class GetClass3 {
    public static void main(String[] args) {
        Class<Users> usersClass = Users.class;
        Class<Users> usersClass1 = Users.class;
        System.out.println(usersClass);
        System.out.println(usersClass.getName());
        System.out.println(usersClass==usersClass1);
    }
}
