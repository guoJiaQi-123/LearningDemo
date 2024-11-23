package com.feishu._09DynamicProgramming;

/**
 * @version v1.0
 * @author OldGj 2024/11/23
 * @apiNote 518. 零钱兑换 II
 */
public class E10change {
    /*
           0   1     2     3     4      5     总金额 -> 背包容量
       1   1   1     11    111   1111   11111
              (1)    (1)   (1)   (1)    (1)

       2   1   1     11    111   1111   11111
                     2     21    211    2111
                                 22     21
              (1)    (2)   (2)   (3)    (3)

       5   1   1     11    111   1111   11111
                     2     21    211    2111
                                 22     21
                                        5
              (1)    (1)   (1)   (1)    (4)

     */
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        // 初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < amount + 1; j++) {
            if (j >= coins[0]) {
                dp[0][j] = dp[0][j - coins[0]];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            int coin = coins[i];
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coin) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][amount];
    }

    /**
     * 降维
     * @param amount
     * @param coins
     * @return
     */
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // 初始化
        for (int i = 0; i < dp.length; i++) {
            dp[0] = 1;
        }
        for (int coin : coins) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coin) {
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
        }
        return dp[amount];
    }
}
