package com.tyut;

import java.io.*;
import java.lang.annotation.ElementType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author OldGj 2024/03/20
 * @version v1.0
 * @apiNote P9240 [蓝桥杯 2023 省 B] 冶炼金属
 */
public class E11P9240Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer streamTokenizer = new StreamTokenizer(bufferedReader);
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    /*
            75 / 3 = 25
            53 / 2 = 26.5
     */
    /*public static void main(String[] args) throws IOException {
        int n = nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int A = nextInt();
            int B = nextInt();
            map.put(A, B);
        }
        int max = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            max = Math.max(max, key / value);

        }
        int cmax = max;
        int resMax = max + 1;
        int resMin = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            while (key / cmax != value) {
                cmax--;
            }
            resMax = Math.min(resMax, cmax);
            while (key / cmax == value) {
                cmax--;
            }
            resMin = Math.max(resMin, cmax + 1);
            cmax = max;
        }
        pw.println(resMin + " " + resMax);
        pw.close();
    }*/

    static int[] a; // 全局数组，用于存放a
    static int[] b; // 全局数组，用于存放b

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            b[i] = nextInt();
        }
        // 二分查找
        int start1 = 0;
        int end1 = 1000000000;
        while (start1 <= end1) {
            int v_mid = (start1 + end1) >>> 1;
            if (m1(v_mid)) {
                end1 = v_mid - 1;
            } else {
                start1 = v_mid + 1;
            }
        }
        int start2 = 0;
        int end2 = 1000000000;
        while (start2 <= end2) {
            int v_mid = (start2 + end2) >>> 1;
            if (m2(v_mid)) {
                end2 = v_mid - 1;
            } else {
                start2 = v_mid + 1;
            }
        }
        pw.println(start1 + " " + start2);
        pw.close();
    }

    /**
     * <p>此方法用于求v的最小值，最大值要满足 a > b * v</p>
     */
    private static boolean m2(int vMid) {
        for (int i = 0; i < a.length; i++) {
            int a_v = a[i];
            int b_v = b[i];
            if (vMid >= a_v / b_v) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>此方法用于求v的最小值，最小值需要满足 a < b * v + v</p>
     * <p>提出v 可得 v > a / (b + 1) </p>
     * <p>因此当vMid <= a_v / (b_v + 1)时，返回false,扩大v范围</p>
     */
    private static boolean m1(int vMid) {
        for (int i = 0; i < a.length; i++) {
            int a_v = a[i];
            int b_v = b[i];
            if (vMid <= a_v / (b_v + 1)) {
                return false;
            }
        }
        return true;
    }


    public static String nextLine() throws IOException {
        return bufferedReader.readLine();
    }

    public static int nextInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }


}
