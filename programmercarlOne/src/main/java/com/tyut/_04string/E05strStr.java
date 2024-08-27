package com.tyut._04string;

/**
 * @author OldGj 2024/03/27
 * @version v1.0
 * @apiNote 28. 找出字符串中第一个匹配项的下标
 */
public class E05strStr {

    // 暴力
    public static int strStr(String haystack, String needle) {
        char[] origin = haystack.toCharArray();  // 原始字符串
        char[] pattern = needle.toCharArray(); // 模式字符串
        int i = 0; // 操作原始字符串的指针
        int j = 0;  // 操作模式字符串的指针
        while (i <= origin.length - pattern.length) {
            for (j = 0; j < pattern.length; j++) {
                if (pattern[j] != origin[i + j]) {
                    break;
                }
            }
            if (j == pattern.length) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // 暴力字符串查找 - 算法 4
    public static int strStr2(String haystack, String needle) {
        char[] origin = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        int N = origin.length;
        int M = pattern.length;
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) { // 对于每一个i，j都从零开始匹配
                if (pattern[j] != origin[i + j]) {
                    break;
                }
            }
            if (j == M) {  // 找到匹配
                return i;
            }
        }
        return -1; // 未找到匹配
    }

    // 算法4-暴力子字符匹配算法的另一种实现（显示回退）
    public static int strStr3(String txt, String pat) {
        int i; // 控制文本字符串
        int j; // 控制模式字符串
        int M = pat.length();
        int N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) { // 匹配相等
                j++;
            } else { // 匹配不相等
                i = i - j; // 文本字符串回到上次匹配开始的位置
                j = 0; // 模式字符串回到起始位置
            }
        }
        if (j == M) {
            return i - j;
        } else {
            return -1;
        }
    }
}
