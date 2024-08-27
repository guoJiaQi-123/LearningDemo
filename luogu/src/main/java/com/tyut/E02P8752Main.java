package com.tyut;

import java.util.Scanner;

/**
 * @author OldGj 2024/03/19
 * @version v1.0
 * @apiNote P8752 [蓝桥杯 2021 省 B2] 特殊年份
 */
public class E02P8752Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < 5; i++) {
            String srt = scan.nextLine();
            if (srt.charAt(0) == srt.charAt(2) && srt.charAt(1) + 1 == srt.charAt(3)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
//Integer.parseInt(String.valueOf(srt.charAt(1))) + 1 == Integer.parseInt(String.valueOf(srt.charAt(3)))) {