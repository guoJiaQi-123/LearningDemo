package com.itbaizhan;/*
 *作者：郭家旗
 *时间：2023/09/08
 *本类内容：
 */

import java.util.Scanner;

public class CZHomeWork06 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int result;
        if (a <= 10) {
            result = a * 6;
        }
        else if (a <= 20) {
            result = 10 * 6 + (a - 10) * 2;
        }
        else {
            result = 10 * 6 + 10 * 2 + (a - 20);
        }
        System.out.println(result);
    }
}
