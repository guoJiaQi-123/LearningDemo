package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/10
 *本类内容：打印菱形
 */

import java.util.Scanner;

public class CZHomeWORK08 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入你想要的菱形边长：");
        int n=scanner.nextInt();
        int k =n-1;
        for(int i=-n+1;i<n;i++){
            for(int j=n-1;j>-n+1;j--){
                if((Math.abs(i)+Math.abs(j))<n){
                    System.out.print("*");
                }else System.out.print(" ");
                if(i==0&&j==0){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
