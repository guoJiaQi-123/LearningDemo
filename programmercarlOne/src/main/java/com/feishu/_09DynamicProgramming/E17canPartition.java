package com.feishu._09DynamicProgramming;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/12/16
 * @apiNote 416. 分割等和子集
 */
public class E17canPartition {
    /*
            0    1    2    3    4    5    6    7    8    9    10    11
        1   0    1    1    1    1    1    1    1    1    1    1      1
        5   0    1    1    1    1    5    6    6    6    6    6      6
       11   0    1    1    1    1    5    6    6    6    6    6      11
        5   0    1    1    1    1    5    6    6    6    6    10     11
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        // 如果和为奇数，则不可能
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        // DP数组的含义：DP[i][j]表示 背包总容量（所能装的总重量）是j，放进物品nums[i]后，背的最大重量为dp[j]。
        // eg：dp[0][11]表示背包容量为11，放入重量为1的物品nums[0]后，最大重量仍然为1
        // eg：dp[3][11]表示背包容量为11，放入重量为1,5,11,5的物品后，最大重量为11
        int[][] dp = new int[nums.length][target + 1];
        // 初始化
        for (int j = nums[0]; j <= target; j++) {
            dp[0][j] = nums[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                if (j < nums[i]) // 放不下
                    dp[i][j] = dp[i - 1][j];
                else // 放得下 比较「原先最大」和「当前物品+除去当前物品的剩余空间最大」哪个更大
                    dp[i][j] = Math.max(dp[i - 1][j], nums[i] + dp[i - 1][j - nums[i]]);
            }
        }
        return dp[len - 1][target] == target;
    }


}
