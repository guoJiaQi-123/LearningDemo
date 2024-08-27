package com.tyut._04string;

import java.util.Arrays;

/**
 * @author OldGj 2024/03/29
 * @version v1.0
 * @apiNote 28.字符串匹配算法KMP
 */
public class E06strStrKMP {
    public static int strStr(String haystack, String needle) {
        char[] origin = haystack.toCharArray(); // 原始字符串
        char[] pattern = needle.toCharArray(); // 模式字符串
        // 根据模式字符串求出前缀表数组（ 最长相等前后缀 ）
        int[] next = getNext(pattern);
        int i = 0; // 操作原始字符串
        int j = 0; // 操作模式字符串
        while ((origin.length - i) >= (pattern.length - j)) {
            if (origin[i] == pattern[j]) { // 匹配成功
                i++;
                j++;
            } else if (j == 0) { // 匹配不成功，并且j==0
                i++;
            } else {
                j = next[j - 1];  // j 根据最长公共前缀中的值，向回找
                // lps[j - 1]表示模式字符串中前j个字符组成的字符串的最长公共前缀
            }
            if (j == pattern.length) {
                return i - j;
            }
        }
        return -1;
    }

    /**
     * KMP算法核心 - 根据模式字符串计算最长相等前后缀
     *
     * @param pattern 模式字符串
     * @return 前缀表
     */
    private static int[] getNext(char[] pattern) {
        int[] next = new int[pattern.length];
        int i = 1; // 后缀
        int j = 0; // 前缀 同时也是数量
        while (i < pattern.length) {
            if (pattern[i] == pattern[j]) { // 匹配成功
                j++; // 先j++再更新next数组的值
                next[i] = j; // 记录共同前后缀长度
                i++;
            } else if (j == 0) { // j 前面没有公共前缀
                i++;
            } else {
                j = next[j - 1]; // j 向回找
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int[] next = getNext("letleto".toCharArray()); // 0001230
        System.out.println(Arrays.toString(next));
//        int i = strStr("leetcode", "leeto");
//        System.out.println(i);
    }


}
