package com.itbaizhan;

import java.util.Arrays;

public class TestBubbleSort{
    public static void main(String[] args) {
        int a[]={15,84,42,22,5,2,56,12,55};
        System.out.println("初始状态："+Arrays.toString(a));
        BubbleSort(a);

    }
    public static void BubbleSort(int[] a){
        int t;
        for(int i=0;i<a.length;i++){
            boolean panduan =true;
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                    panduan=false;
                }
            }
        if(panduan){
            break;
        }
            System.out.println("第"+(i+1)+"次交换："+Arrays.toString(a));



        }
    }

}
