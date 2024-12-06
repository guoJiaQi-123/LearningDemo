package com.feishu._09DynamicProgramming;

/**
 * @version v1.0
 * @author OldGj 2024/12/6
 * @apiNote 583. 两个字符串的删除操作
 */
public class E14minDistance {
    /*
        删除字符的个数  ==  两个字符串的总个数  -  2 * 最长公共子序列的长度
     */

    public int minDistance(String word1, String word2) {
        // 最长公共自序列的长度
        int commonSubsequence = longestCommonSubsequence(word1, word2);
        return word1.length() + word2.length() - 2 * commonSubsequence;
    }

    /**
     * 求两个字符串的最长公共字符串
     * @param text1
     * @param text2
     * @return
     */
    @SuppressWarnings("all")
    public int longestCommonSubsequence(String text1, String text2) {
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
}
