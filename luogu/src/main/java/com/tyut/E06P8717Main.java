package com.tyut;

import java.util.Scanner;

/**
 * @author OldGj 2024/03/20
 * @version v1.0
 * @apiNote P8717 [蓝桥杯 2020 省 AB2] 成绩分析
 */
public class E06P8717Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int max = -1;
        int min = 101;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            int m = scan.nextInt();
            max = Math.max(max, m);
            min = Math.min(min, m);
            sum += m;
        }
        System.out.println(max);
        System.out.println(min);
        System.out.printf("%.2f", sum / n); // 格式化输出
        scan.close();
    }
}
