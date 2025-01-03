package com.feishu._09DynamicProgramming;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2025/1/2
 * @apiNote 279. 完全平方数
 */
public class E22numSquares implements Serializable, Cloneable {

    /*
                [0, 1, 2147483647, 2147483647, 2147483647, 2147483647]
                [0, 1, 2, 2147483647, 2147483647, 2147483647]
                [0, 1, 2, 3, 2147483647, 2147483647]
                [0, 1, 2, 3, 4, 2147483647]
                [0, 1, 2, 3, 4, 5]
                [0, 1, 2, 3, 1, 5]
                [0, 1, 2, 3, 1, 2]
         */
    // 版本一，先遍历物品, 再遍历背包
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        //初始化
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        //如果不想要用for-loop填充數組的話，也可以用JAVA內建的Arrays.fill()函數。
        //Arrays.fill(dp, Integer.MAX_VALUE);

        //当和为0时，组合的个数为0
        dp[0] = 0;
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new E22numSquares().numSquares(5);
    }
}
