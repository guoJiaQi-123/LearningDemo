package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/27
 *本类内容：
 */

import java.lang.reflect.Constructor;

public class GetConstructor {
    public static void main(String[] args) throws Exception{
        Class<Users> usersClass = Users.class;
        Constructor<?>[] arr = usersClass.getDeclaredConstructors();
        for(Constructor constructor:arr){
            System.out.println(constructor);
        }
        System.out.println("=====================");

        Constructor<?>[] arr2 = usersClass.getConstructors();
        for(Constructor constructor:arr2){
            System.out.println(constructor);
        }
        System.out.println("=====================");

        Constructor<Users> constructor = usersClass.getDeclaredConstructor(String.class);
        System.out.println(constructor);
        System.out.println("=====================");

        Constructor<Users> constructor1 = usersClass.getConstructor(String.class,int.class);
        System.out.println(constructor1);


    }
}
