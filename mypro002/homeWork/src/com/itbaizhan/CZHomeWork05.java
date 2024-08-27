package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/08
 *本类内容：
 */

import java.util.Scanner;

public class CZHomeWork05 {
    public static void main(String[] args) {
        int a,b,c;
        int max=0;
        Scanner scanner=new Scanner(System.in);
        a=scanner.nextInt();
        b=scanner.nextInt();
        c=scanner.nextInt();
        if(a>b&&a>c){
            max=a;
        }
        if(a<b&&b>c){
            max=b;
        }
        if(c>b&&a<c){
            max=c;
        }
        System.out.println(max);
    }
}
