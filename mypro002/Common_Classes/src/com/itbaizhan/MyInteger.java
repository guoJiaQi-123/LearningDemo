package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/04
 *本类内容： 自定义类
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyInteger {
    private final int value;
    private static MyInteger[] cache;
    private static final int MAX =127;
    private static final int LOW = -128;
    static {
        cache=new MyInteger[MAX-LOW+1];
        for(int i=LOW;i<=MAX;i++){
            cache[i-LOW]=new MyInteger(i);
        }
        System.out.println(Arrays.toString(cache));
    }

    @Override
    public String toString() {
        return ""+value;
    }

    public MyInteger(int value){
        this.value=value;
    }

    private static MyInteger valueOf(int value){
        if(value>=LOW&&value<=MAX){
            return cache[value-LOW];
        }else return new MyInteger(value);
    }

    public static void main(String[] args) {
        MyInteger a1 = new MyInteger(100);
        MyInteger b1 = MyInteger.valueOf(100);
        MyInteger b2 = MyInteger.valueOf(100);
        MyInteger b3 = MyInteger.valueOf(1000);
        MyInteger b4 = MyInteger.valueOf(1000);
        System.out.println(b1==b2);
        System.out.println(b3==b4);
    }
}
