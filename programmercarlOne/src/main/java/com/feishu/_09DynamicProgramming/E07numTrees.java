package com.feishu._09DynamicProgramming;

/**
 * @version v1.0
 * @author OldGj 2024/11/12
 * @apiNote 96. 不同的二叉搜索树
 * 卡特兰数
 */
public class E07numTrees {
    /*
        0   1   2   3   4   5
        1   1   2   5   14  42

        dp[2] = dp[0]*dp[1] + dp[1]*dp[0] = 1+1 = 2
        dp[3] = dp[0]*dp[2] + dp[1]*dp[1] + dp[2]*dp[0] = 2+1+2 = 5
        dp[4] = dp[0]*dp[3] + dp[1][2] + dp[2][1] + dp[3][0] = 5+2+2+5 = 14
        dp[5] = dp[0]*dp[4] + dp[1][3] + dp[2][2] + dp[3][1] + dp[4][0] = 14+5+2+2+5+14 = 42
     */
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j]; // dp[i]表示i个节点能组成的不同二叉搜索数的个数
            }
        }
        return dp[n];
    }
}
