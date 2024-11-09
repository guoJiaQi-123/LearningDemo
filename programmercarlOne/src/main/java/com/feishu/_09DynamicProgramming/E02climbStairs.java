package com.feishu._09DynamicProgramming;

/**
 * @version v1.0
 * @author OldGj 2024/11/9
 * @apiNote 70. 爬楼梯
 */
public class E02climbStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        // i:第i层楼  dp[i]:爬i层楼有多少种方法
        int[] dp = new int[n + 1];
        // dp数组初始化
        dp[1] = 1;
        dp[2] = 2;
        // 状态转移方程：dp[i] = dp[i - 1] + dp[i - 2];
        //  因为 首先是dp[i - 1]，上i-1层楼梯，有dp[i - 1]种方法，那么再一步跳一个台阶不就是dp[i]了么。
        //  还有就是dp[i - 2]，上i-2层楼梯，有dp[i - 2]种方法，那么再一步跳两个台阶不就是dp[i]了么。
        //  那么dp[i]就是 dp[i - 1]与dp[i - 2]之和！
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
