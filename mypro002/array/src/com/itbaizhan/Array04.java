package com.itbaizhan;

import java.util.Arrays;

//测试java.util.Array类          打印.toString      排序.sort       查找.binarySearch     填充.fill
public class Array04 {

    public static void main(String[] args) {
        int a[]={12,13,541,852,451,22};
        System.out.println(a);                  //打印数组引用的值
        System.out.println(Arrays.toString(a));//打印数组元素的值
        Arrays.sort(a);                        //将数组元素进行排序
        System.out.println(Arrays.toString(a));
        //使用二分法查找数组中元素的索引      返回排序后新的索引位置，若未找到则返回一个负数
        System.out.println("该元素的索引为："+Arrays.binarySearch(a,852));//使用二分法查找必须对数组先进行排序

        int b[]={12,48,54,651};
        System.out.println(Arrays.toString(b));
        Arrays.fill(b,2,3,200);   //填充
        System.out.println(Arrays.toString(b));
    }
}
