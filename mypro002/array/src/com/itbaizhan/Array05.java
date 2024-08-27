package com.itbaizhan;
import java.util.Arrays;
//测试多维数组
public class Array05 {

    public static void main(String[] args) {
        int a[][]=new int[3][];//声明一个数组
        //Java中声明和初始化一个多维数组应该从低维到高维的顺序
        a[0]=new int[2];
        a[1]=new int[3];
        a[2]=new int[4];
        //int a[][]=new int[][4];    //非法
        a[0][0]=2;
        a[0][1]=3;

        //多维数组的静态初始化
        int b[][]={{15,5,2},{56,552,541}};
        System.out.println(b[0][2]);

        //多维数组的动态初始化
        int c[][]=new int[2][];
        //c[0]={12,58,45};   不对，应该先声明类型
        c[0]=new int[]{12,58,45};
        c[1]=new int[]{52,4};
        System.out.println(c[0][2]);
        System.out.println(Arrays.toString(c[0]));
        System.out.println(Arrays.toString(c[1]));


    }
}
