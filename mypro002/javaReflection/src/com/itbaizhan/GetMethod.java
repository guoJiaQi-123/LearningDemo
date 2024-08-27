package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/27
 *本类内容：
 */

import java.lang.reflect.Method;

public class GetMethod {
    public static void main(String[] args) throws Exception{
        Class<Users> usersClass = Users.class;
        Method[] classMethods = usersClass.getMethods();
        for(Method method : classMethods){
            System.out.println(method);
            System.out.println(method.getName());
        }
        System.out.println("----------------");
        Method[] declaredMethods = usersClass.getDeclaredMethods();
        for(Method method : declaredMethods){
            System.out.println(method);
            System.out.println(method.getName());
        }
        System.out.println("=================");
        Method setUserAge = usersClass.getMethod("setUserAge", int.class);
        System.out.println(setUserAge.getName());
        System.out.println(setUserAge);
        System.out.println("===============");
        Method sing = usersClass.getDeclaredMethod("sing");
        System.out.println(sing);
        System.out.println(sing.getName());
    }
}
