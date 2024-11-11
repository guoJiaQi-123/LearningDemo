package com.feishu._09DynamicProgramming;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/11/10
 * @apiNote 63. 不同路径 II
 */
public class E05uniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径
        int[][] dp = new int[m][n];
        //如果在起点或终点出现了障碍，直接返回0
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        // 初始化，如果在第一列或者第一行出现障碍，则障碍后面全部不可达，为0
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) { // 当前位置没有障碍，则当前位置的路径为左边➕上边的和
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0; // 当前位置有障碍，那么到当前位置的路径为0
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] arg = new int[3][3];
        arg[0] = new int[]{0, 1, 0};
        arg[1] = new int[]{1, 0, 0};
        arg[2] = new int[]{0, 0, 0};
        System.out.println(new E05uniquePathsWithObstacles().uniquePathsWithObstacles(arg));
    }
}
