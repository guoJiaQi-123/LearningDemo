package com.itbaizhan;
//测试数组的三种初始化方式
public class Array01 {
    public static void main(String[] args) {
        int a[]={0,1,2,3,4};  // 静态初始化基本类型数组；
        //man mans[]={new man(1001,"郭家旗"),new man(1002,"苏红润")};

        int b[];              //动态初始化
        b = new int[2];
        b[0]=0;               //给数组元素赋值
        b[1]=1;               //给数组元素赋值


        int c[]=new int[5];  //默认初始化，int类型默认为0，引用类型默认为null，布尔类型默认为false
        System.out.println(c[0]);
    }


}
