package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/06
 *本类内容：求素数
 */

import java.util.Scanner;

public class CZHomeWork04 {

    public void suShu(int a){
        for (int i=0;i<a;i++){
            if(i%2!=0&&i%3!=0&&i%5!=0&&i%7!=0){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入一个数");
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        CZHomeWork04 czHomeWork04=new CZHomeWork04();
        czHomeWork04.suShu(a);

    }
}
