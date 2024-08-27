package com.tyut;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author OldGj 2024/03/20
 * @version v1.0
 * @apiNote P8722 [蓝桥杯 2020 省 AB3] 日期识别
 */
public class E09P8722Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer streamTokenizer = new StreamTokenizer(bufferedReader);
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws Exception {
        String s = nextLine();
        Map<String, Integer> monthMap = new HashMap<>();
        monthMap.put("Jan", 1);
        monthMap.put("Feb", 2);
        monthMap.put("Mar", 3);
        monthMap.put("Apr", 4);
        monthMap.put("May", 5);
        monthMap.put("Jun", 6);
        monthMap.put("Jul", 7);
        monthMap.put("Aug", 8);
        monthMap.put("Sep", 9);
        monthMap.put("Oct", 10);
        monthMap.put("Nov", 11);
        monthMap.put("Dec", 12);
        Map<String, Integer> dayMap = new HashMap<>();
        dayMap.put("01", 1);
        dayMap.put("02", 2);
        dayMap.put("03", 3);
        dayMap.put("04", 4);
        dayMap.put("05", 5);
        dayMap.put("06", 6);
        dayMap.put("07", 7);
        dayMap.put("08", 8);
        dayMap.put("09", 9);
        String s1 = s.substring(0, 3);
        String s2 = s.substring(3);
        Integer i = dayMap.get(s2);
        if (i == null) {
            i = Integer.valueOf(s2);
        }
        pw.print(monthMap.get(s1) + " " + i);
        pw.close();
    }

    public static String nextLine() throws Exception {
        return bufferedReader.readLine();
    }
    public static int nextInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    public static long nextLone() throws Exception {
        streamTokenizer.nextToken();
        return (long) streamTokenizer.nval;
    }

    public static double nextDouble() throws Exception {
        streamTokenizer.nextToken();
        return streamTokenizer.nval;
    }

    public static String next() throws Exception {
        streamTokenizer.nextToken();
        return streamTokenizer.sval;
    }
}
