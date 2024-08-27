package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/05
 *本类内容：打印九九乘法表
 */

public class CZHomeWork02 {

    public static void main(String[] args) {
        for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                int result=i*j;
                System.out.print(i+"*"+j+"="+result+"\t");
            }
            System.out.println();//换行
        }
    }
}
