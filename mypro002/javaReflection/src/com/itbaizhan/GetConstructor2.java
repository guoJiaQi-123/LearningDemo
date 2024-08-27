package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/27
 *本类内容：通过反射实例化对象
 */

import java.lang.reflect.Constructor;

public class GetConstructor2 {
    public static void main(String[] args) throws Exception{
        //创建类对象
        Class<Users> usersClass = Users.class;
        //通过类对象获取指定的构造方法对象
        Constructor<Users> constructor = usersClass.getConstructor(String.class, int.class);
        //通过指定的构造方法对象创建对象
        Users users = constructor.newInstance("郭家旗", 20);

        System.out.println(users);
    }
}
