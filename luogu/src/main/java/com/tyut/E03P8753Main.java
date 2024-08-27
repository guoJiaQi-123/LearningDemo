package com.tyut;

import java.util.Scanner;

/**
 * @author OldGj 2024/03/20
 * @version v1.0
 * @apiNote P8753 [蓝桥杯 2021 省 AB2] 小平方
 */
public class E03P8753Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        double r = n / 2.0; // 此处有坑！int取值是向下取整，此处应该使用double浮点数
        for (int i = 1; i < n; i++) {
            int ii = i * i; // 平方
            if (ii % n < r) {
                count++;
            }
        }
        System.out.println(count);
        scan.close();
    }
}
