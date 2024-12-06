package com.feishu._09DynamicProgramming;

/**
 * @version v1.0
 * @author OldGj 2024/12/6
 * @apiNote 1143. 最长公共子序列
 */
public class E13longestCommonSubsequence {

    /*

                a   b   c   d   e
            0   0   0   0   0   0
       a    0   1   1   1   1   1
       c    0   1   1   2   2   2
       e    0   1   1   2   2   3

         相同字符
            找到上一行上一列数值 + 1
         不同字符
            max(上一行, 上一列)

     */

    public static int longestCommonSubsequence(String text1, String text2) {
        char[] array1 = text1.toCharArray();
        char[] array2 = text2.toCharArray();
        int[][] dp = new int[array1.length + 1][array2.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (array1[i - 1] == array2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;  // 找到上一行上一列数值 + 1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //  max(上一行, 上一列)
                }
            }
        }
        return dp[array1.length][array2.length];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ace", "abcde"));
    }
}
