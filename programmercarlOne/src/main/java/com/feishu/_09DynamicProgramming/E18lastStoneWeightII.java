package com.feishu._09DynamicProgramming;

import java.util.Arrays;

import static com.feishu._09DynamicProgramming.E08KnapsackProblem.print;

/**
 * @version v1.0
 * @author OldGj 2024/12/16
 * @apiNote 1049. 最后一块石头的重量 II
 */
public class E18lastStoneWeightII {
    /*
             0     1     2     3     4     5     6     7     8     9    10    11
        2    0     0     2     2     2     2     2     2     2     2     2     2
        7    0     0     2     2     2     2     2     7     7     9     9     9
        4    0     0     2     2     4     4     6     7     7     9     9    11
        1    0     1     2     3     4     5     6     7     8     9    10    11
        8    0     1     2     3     4     5     6     7     8     9    10    11
        1    0     1     2     3     4     5     6     7     8     9    10    11
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int half = sum >>> 1;
        int[][] dp = new int[stones.length][half + 1];
        // 初始化
        for (int j = 0; j < half + 1; j++) {
            if (j >= stones[0]) {
                dp[0][j] = stones[0];
            }
        }
        // 01 背包
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < half + 1; j++) {
                if (j >= stones[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], stones[i] + dp[i - 1][j - stones[i]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - dp[stones.length - 1][half] - dp[stones.length - 1][half];
    }
}
