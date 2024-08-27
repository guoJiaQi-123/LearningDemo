package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/27
 *本类内容：
 */

import java.lang.reflect.Method;

class Reflect {
    public Reflect(){

    }
    public void method1(){
        System.out.println("method1---------");
    }
    public void method2(){
        System.out.println("method2---------");
    }
    public void method3(){
        System.out.println("method3---------");
    }
}


public class ReflectDemo {
    public static void main(String[] args) throws Exception{
        Class<Reflect> reflectClass1 = Reflect.class;
        Reflect reflect = reflectClass1.getConstructor(null).newInstance();
        if(args!=null&&args.length>0){
            Method[] classMethods = reflectClass1.getMethods();
            for(String s:args){
                for(Method method:classMethods){
                    if(s.equalsIgnoreCase(method.getName())){
                        method.invoke(reflect);
                        break;
                    }
                }
            }
        }else {
            reflect.method1();
            reflect.method2();
            reflect.method3();
        }
    }
}
