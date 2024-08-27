package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/27
 *本类内容：
 */

import java.lang.reflect.Field;

public class GetField {
    public static void main(String[] args) throws Exception{
        Class<Users> usersClass = Users.class;
        Field[] fields = usersClass.getFields();
        for(Field field:fields){
            System.out.println(field);
        }
        System.out.println("===================");
        Field[] declaredFields = usersClass.getDeclaredFields();
        for(Field field:declaredFields){
            System.out.println(field);
        }
        System.out.println("=================");
        Field userName = usersClass.getDeclaredField("userName");
        System.out.println(userName);
        System.out.println("=================");
        Field userAge = usersClass.getField("userAge");
        System.out.println(userAge);
    }
}
