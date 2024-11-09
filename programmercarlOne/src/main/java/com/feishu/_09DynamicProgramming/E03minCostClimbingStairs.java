package com.feishu._09DynamicProgramming;

/**
 * @version v1.0
 * @author OldGj 2024/11/9
 * @apiNote 746. 使用最小花费爬楼梯
 */
public class E03minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        // dp[i]的定义：到达第i台阶所花费的最少体力为dp[i]。
        int[] dp = new int[len + 1];
        // 状态转移方程：dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        // 解读：要到台阶n可以从n-1来或者n-2来，从n-1来需要花费dp[i - 1] + cost[i - 1]这么多体力
        // 要从n-2来需要花费dp[i - 2] + cost[i - 2]这么多体力，我们从花费体力少的那个来，所以去min
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];
    }
}
