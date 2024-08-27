package com.feishu._04str;

/**
 * @version v1.0
 * @author OldGj 2024/8/7
 * @apiNote 28. 找出字符串中第一个匹配项的下标
 */
public class E05strStr_KMP {
    public int strStr(String haystack, String needle) {
        char[] origin = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        // 根据模式字符串先求最长公共前后缀数组
        /*
                        i
                    a   a   b   a
                b   a   b   a   a   b   a
                        j
         */
        int[] lps = lsp(pattern);
        int i = 0;
        int j = 0;
        while ((pattern.length - j) <= (origin.length - i)) {
            if (pattern[j] == origin[i]) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = lps[j - 1];
            }
            if (j == lps.length) {
                return i - j;
            }
        }
        return -1;
    }

    private int[] lsp(char[] pattern) {
        /*
                    j
                    a   a   a   b
                a   a   a   b
                    i
         */
        int[] lsp = new int[pattern.length];
        int i = 1;
        int j = 0;
        while (i < lsp.length) {
            if (pattern[i] == pattern[j]) {
                lsp[i] = j + 1;
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = lsp[j - 1];
            }
        }
        return lsp;
    }
}
