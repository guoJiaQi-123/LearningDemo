package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/09
 *本类内容：
 */

import java.util.Scanner;

public class CZHomeWork07 {


    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n =scanner.nextInt();
        int a=3;
        int sum=0;
        if(n>2&&n<30){
            for (int i=1;i<=10;i++){
                int sum1=0;
                sum1+=i;
                if(n/3==i){

                    sum=i*n-sum1*a;
                }
            }
        }
        System.out.println(sum);
    }
}
