package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/05
 *本类内容：输入一个三位数，分别输出个十百位数
 */

import java.util.Scanner;

public class CZHomeWork {

    public static void main(String[] args) {
        System.out.println("请输入一个三位数：");
        Scanner scanner=new Scanner(System.in);
        int a =scanner.nextInt();
        if(a<100||a>=1000){
            System.out.println("请输入正确的三位数：");
        }else {
            System.out.println(a/100);
            System.out.println(a%100/10);
            System.out.println(a%10);
        }
    }
}
