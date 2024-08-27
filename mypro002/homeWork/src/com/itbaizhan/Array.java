package com.itbaizhan;

public class Array {
    public static void main(String[] args) {
        int[] s;                             //声明数组
        s = new int[10];                     //给数组分配空间

        for(int i=0;i<10;i++){
            s[i] = 1+2*i;                   //给数组元素赋值； 数组是对象，数组中的元素就是对象的属性
            System.out.println(s[i]);
        }


    }
}



