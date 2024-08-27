package com.tyut;

import java.io.*;
import java.util.Scanner;

/**
 * @author OldGj 2024/03/21
 * @version v1.0
 * @apiNote P9420 [蓝桥杯 2023 国 B] 子 2023 / 双子数
 */
public class E12P9420Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer streamTokenizer = new StreamTokenizer(bufferedReader);
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


    public static void main(String[] args) throws IOException {
        String n = nextLine();
        if ("A".equals(n)) { // 第一个问题
            long dp1 = 0; // 2
            long dp2 = 0; // 20
            long dp3 = 0; // 202
            long dp4 = 0; // 2023
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < 2024; i++) {
                sb.append(i);
            }
            String str = sb.toString();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '2') {
                    dp1++;
                    dp3 = dp3 + dp2;
                } else if (c == '0') {
                    dp2 = dp2 + dp1;
                } else if (c == '3') {
                    dp4 = dp4 + dp3;
                }
            }
            pw.println(dp4);
            pw.close();
        } else { //第二个问题
            int[] aa = new int[4830458];
            aa[2] = 0;
            int k = 2, tt = 0;
            while (tt < 4) {
                //将不是素素的数筛出
                for (int i = 1; i < aa.length; i++)
                    if (i % k == 0 && i != k) {
                        aa[i] = 1;
                    }
                //将筛选后的第一个数当做新的筛子
                for (int i = 1; i < aa.length; i++) {
                    if (i > k && aa[i] == 0) {
                        k = i;
                        break;
                    }
                }
                tt++;
            }
            int count = 0;
            for (int i = 1; i < aa.length; i++) {
                if (aa[i] == 0) {
                    long p = i;
                    if (p * p * p > 23333333333333L) {
                        continue;
                    }
                    for (long j = 2333; j <= 23333333333333L; j++) {
                        if (j % 2 == 0) {
                            continue;
                        }
                        for (int x = i; x < aa.length; x++) {
                            if (aa[x] == 0) {
                                long q = x;
                                if (p * p * q * q < j) {
                                    continue;
                                }
                                if (p * p * q * q > 23333333333333L) {
                                    break;
                                }
                                if (j == p * p * q * q) {
                                    count++;
                                }
                            }
                        }
                        System.out.println(count);
                    }
                }
            }
            pw.println(count);
            pw.close();
        }
    }

    public static String nextLine() throws IOException {
        return bufferedReader.readLine();
    }


}
