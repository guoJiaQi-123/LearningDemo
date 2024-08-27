package com.tyut;

import java.util.Scanner;

/**
 * @author OldGj 2024/03/20
 * @version v1.0
 * @apiNote P8780 [蓝桥杯 2022 省 B] 刷题统计
 */
public class E04P8780Main {
    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long a = scan.nextLong();
        long b = scan.nextLong();
        long n = scan.nextLong();
        int day = 0;
        long sum = 0;
        while (sum < n) {
            for (int i = 0; i < 5; i++) {
                if (sum > n) {
                    break;
                }
                sum += a;
                day++;
            }
            for (int i = 0; i < 2; i++) {
                if (sum > n) {
                    break;
                }
                sum += b;
                day++;
            }
        }
        System.out.println(day);
        scan.close();
    }*/
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        long a = scan.nextLong();
//        long b = scan.nextLong();
//        long n = scan.nextLong();
//        long[] weeks = new long[]{a, a, a, a, a, b, b};
//        int week = 0;
//        long count = 0;
//        boolean flag = true;
//        while (flag) {
//            for (int i = 0; i < weeks.length; i++) {
//                if (count >= n) {
//                    System.out.println(week * 7 + i);
//                    flag = false;
//                    break;
//                }
//                count += weeks[i];
//            }
//            week++;
//        }
//        scan.close();
//    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long a = scan.nextLong();
        long b = scan.nextLong();
        long n = scan.nextLong();
        long oneWeek = a * 5 + b * 2; // 一周的总做题数
        long weeks = n / oneWeek; // 做N题需要完整的周数
        long remainder = n - oneWeek * weeks; // 做完weeks周后还剩下的题数（不到一周可以做完）
        // 通过上面的计算，可以大大减少循环的次数，只需要计算剩余题数需要的天数即可
        long count = 0; // 第weeks+1周做的总题数
        int remainderDay = 0; // 还需要的天数
        // 因为剩余题数最多不会超过一周的题量，因此直接循环一次即可
        for (int i = 0; i < 5; i++) {
            if (count >= remainder) {
                break;
            }
            count += a;
            remainderDay++;
        }
        for (int i = 0; i < 2; i++) {
            if (count >= remainder) {
                break;
            }
            count += b;
            remainderDay++;
        }
        System.out.println(weeks * 7 + remainderDay);
        scan.close();
    }
}
