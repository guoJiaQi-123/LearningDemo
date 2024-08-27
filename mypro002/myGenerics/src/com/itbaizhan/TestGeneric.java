package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/06
 *本类内容：测试泛型接口
 */

public class TestGeneric {

    public static void main(String[] args) {
        IGeneric<String> generic =new IGenericPle<>();
        String name=generic.getName("郭家旗");
        System.out.println(name);


        //方法二
        IGeneric<String> generic1 = new IGenericPle();
        String name2=generic1.getName("郭家旗");
        System.out.println(name2);


    }
}
