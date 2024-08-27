package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/06
 *本类内容：测试泛型方法
 */

public class TestGeneric02 {
    public static void main(String[] args) {
        MethodGeneric methodGeneric=new MethodGeneric();
        String arr[]=new String[]{"a","b","c"};
        Integer arr2[]=new Integer[]{1,2,3,4};
        methodGeneric.method(arr);
        methodGeneric.method(arr2);

        /*MethodGeneric methodGeneric =new MethodGeneric();
        methodGeneric.setName("苏红润");//调用无返回值的方法

        Integer age = methodGeneric.getAge(19);//调用有返回值的方法
        System.out.println(age);*/
    }
}
