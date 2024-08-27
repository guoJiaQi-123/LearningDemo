package com.itbaizhan;

import java.util.Arrays;

//测试数组的拷贝
public class Array03 {

    public static void main(String[] args) {
        int a[]={12,15,255,1445,1,42,4};
        int b[]=new int[8];
        System.arraycopy(a,0,b,0,a.length);
        System.out.println(Arrays.toString(b));
    }
}
