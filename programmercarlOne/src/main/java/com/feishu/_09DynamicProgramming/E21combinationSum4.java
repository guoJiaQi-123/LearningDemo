package com.feishu._09DynamicProgramming;

/**
 * @version v1.0
 * @author OldGj 2025/1/1
 * @apiNote 377. 组合总和 Ⅳ
 */
public class E21combinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) { // 装得下
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
