package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/27
 *本类内容：
 */

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception{

        Class<Users> aClass = Users.class;
        Object o = aClass.getConstructor(null).newInstance();
        Method setUsername = aClass.getMethod("setUserName", String.class);
        long reflectStart = System.currentTimeMillis();
        for(int i =0;i<100000000;i++){
            setUsername.invoke(o,"郭家旗");
        }
        long reflectEnd = System.currentTimeMillis();

        long start = System.currentTimeMillis();
        Users u =new Users();
        for(int i=0;i<100000000;i++){
            u.setUserName("郭家旗");
        }
        long end = System.currentTimeMillis();

        System.out.println("反射："+(reflectEnd-reflectStart));
        System.out.println("普通："+(end-start));
    }
}
