package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/27
 *本类内容：
 */

import java.lang.reflect.Field;

public class GetField2 {
    public static void main(String[] args)throws Exception {
        //获取Users类的类对象
        Class<Users> usersClass = Users.class;
        //获取类的成员变量
        Field userAge = usersClass.getField("userAge");
        //通过构造方法实例化users对象
        Users users = usersClass.getConstructor(null).newInstance();
        //给指定成员变量赋值
        userAge.set(users,20);
        System.out.println(userAge.get(users));
    }
}
