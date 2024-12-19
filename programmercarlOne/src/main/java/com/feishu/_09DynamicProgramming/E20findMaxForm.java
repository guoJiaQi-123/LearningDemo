package com.feishu._09DynamicProgramming;

import static com.feishu._09DynamicProgramming.E08KnapsackProblem.print;

/**
 * @version v1.0
 * @author OldGj 2024/12/17
 * @apiNote 474. 一和零
 */
public class E20findMaxForm {
    /*

     */
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) { // 遍历物品
            // strs里的字符串有zeroNum个0，oneNum个1
            int oneNum = 0;
            int zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            // 遍历背包容量且从后向前遍历！
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    // dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。
                    // dp[i - zeroNum][j - oneNum] + 1 表示加上当前字符串的子集大，还是不加当前字符串的子集大
                    // 不加当前字符串的子集数为dp[i][j]，加上当前字符串的子集数为dp[i - zeroNum][j - oneNum] + 1
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
            print(dp);
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        new E20findMaxForm().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 3, 3);
    }
}
