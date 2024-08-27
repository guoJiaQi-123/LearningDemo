package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/27
 *本类内容：
 */

import java.lang.reflect.Method;

public class GetMethod2 {
    public static void main(String[] args)throws Exception {
        //实例化类对象
        Class<Users> usersClass = Users.class;
        Method setUserName = usersClass.getMethod("setUserName", String.class);
        //实例化对象
        Users users = usersClass.getConstructor(null).newInstance();
        //通过setUserName赋值
        setUserName.invoke(users,"郭家旗");
        //通过getUserName获取值
        Method getUserName = usersClass.getMethod("getUserName");
        Object userName = getUserName.invoke(users);
        System.out.println(userName);

    }
}
