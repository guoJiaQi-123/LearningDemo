package com.tyut;

import java.util.Scanner;

/**
 * @author OldGj 2024/03/20
 * @version v1.0
 * @apiNote P8761 [蓝桥杯 2021 国 BC] 大写
 */
public class E07P8761Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // 循环26次，每次把小写a-z替换成大写A-Z
        for (int i = 0; i < 26; i++) {
            char x = (char) ('a' + i);
            char y = (char) (x - 32);
            s = s.replace(x, y);
        }
        System.out.println(s);
    }
}
