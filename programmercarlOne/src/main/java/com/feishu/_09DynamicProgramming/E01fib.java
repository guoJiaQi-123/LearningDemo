package com.feishu._09DynamicProgramming;

/**
 * @version v1.0
 * @author OldGj 2024/11/9
 * @apiNote 509. 斐波那契数
 */
public class E01fib {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        // dps数组初始化
        dp[0] = 0;
        dp[1] = 1;
        // dp数组推导，状态转移方程：dp[i] = dp[i - 1] + dp[i - 2];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 我们只需要维护两个数值就可以了，不需要记录整个序列。
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
