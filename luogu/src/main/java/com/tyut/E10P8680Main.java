package com.tyut;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author OldGj 2024/03/20
 * @version v1.0
 * @apiNote P8680 [蓝桥杯 2019 省 B] 特别数的和
 */
public class E10P8680Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer streamTokenizer = new StreamTokenizer(bufferedReader);
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    //    public static void main(String[] args) throws IOException {
//
//        int n = nextInt();
//        int sum = 0;
//        for (int i = 1; i <= n; i++) {
//            String s = String.valueOf(i);
//            char[] charArray = s.toCharArray();
//            for (char c : charArray) {
//                if (c == '0' || c == '1' || c == '2' || c == '9') {
//                    sum += i;
//                    break;
//                }
//            }
//        }
//        pw.println(sum);
//        pw.close();
//    }
    public static void main(String[] args) throws IOException {
        int n = nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i)) {
                sum += i;
            }
        }
        pw.println(sum);
        pw.close();
    }

    private static boolean check(int i) {
        while (i != 0) {
            int x = i % 10; // 取个位数
            if (x == 2 || x == 0 || x == 1 || x == 9) {
                return true;
            }
            i = i / 10; // 除去个位数
        }
        return false;
    }

    public static String nextLine() throws IOException {
        return bufferedReader.readLine();
    }

    public static int nextInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    public static double nextDouble() throws IOException {
        streamTokenizer.nextToken();
        return streamTokenizer.nval;
    }

    public static long nextLong() throws IOException {
        streamTokenizer.nextToken();
        return (long) streamTokenizer.nval;
    }

    public static String next() throws IOException {
        streamTokenizer.nextToken();
        return streamTokenizer.sval;
    }
}
