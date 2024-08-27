package com.tyut;

import java.util.Scanner;

/**
 * @author OldGj 2024/03/20
 * @version v1.0
 * @apiNote P8706 [蓝桥杯 2020 省 AB1] 解码
 */
public class E05P8706Main {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        String str = scan.nextLine();
//        char[] charArray = str.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < charArray.length; i++) {
//            char c = charArray[i];
//            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
//                char cn = charArray[i + 1];
//                if (cn >= '0' && cn <= '9') {
//                    int x = cn - '0'
//                    for (int j = 0; j < x; j++) {
//                        sb.append(c);
//                    }
//                    i++;
//                } else {
//                    sb.append(c);
//                }
//            }
//        }
//        System.out.println(sb.toString());
//        scan.close();
//    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s0 = scan.nextLine(); // 输入
        char[] s1 = s0.toCharArray(); // 转换为char数组
        String s2 = "";
        for (int i = 0; i < s0.length(); i++) {
            if (s1[i] >= '0' && s1[i] <= '9') { // 如果遍历到的字符是数字
                char ch = s1[i - 1]; // 获取前一个字符
                int num = s1[i] - '0' - 1; // 需要拼接多少字符
                s2 = String.format("%-" + (num + s2.length()) + "s", s2).replace(' ', ch);
            } else s2 += s1[i];
        }
        System.out.println(s2);
    }

}
