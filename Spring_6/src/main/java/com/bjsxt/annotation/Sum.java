package com.bjsxt.annotation;

public class Sum {
    public static void main(String[] args) {
        int j = 10;
        System.out.println(j);
        calcuate(j);
        System.out.println(j);
    }

    private static void calcuate(int a) {
        for(int i=0;i<10;i++){
            a++;
        }
        System.out.println(a);
    }
}
