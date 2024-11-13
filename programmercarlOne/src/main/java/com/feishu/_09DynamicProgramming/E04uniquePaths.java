package com.feishu._09DynamicProgramming;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/11/10
 * @apiNote 62. 不同路径
 */
public class E04uniquePaths {
    public int uniquePaths(int m, int n) {
        // dp[i][j] ：表示从（0 ，0）出发，到(i, j)  有dp[i][j]条不同的路径
        int[][] dp = new int[m][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, 1);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，因为dp[i][j]只有这两个方向过来
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        // 在二维dp数组中，当前值的计算只依赖正上方和正左方，因此可以压缩成一维数组。
        int[] dp = new int[n];
        // 初始化，第一行只能从正左方跳过来，所以只有一条路径。
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            // 第一列也只有一条路，不用迭代，所以从第二列开始
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1]; // dp[j] = dp[j] (正上方)+ dp[j - 1] (正左方)
            }
        }
        return dp[n - 1];
    }

}
