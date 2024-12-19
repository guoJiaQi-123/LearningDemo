package com.feishu._09DynamicProgramming;

import java.util.Arrays;

import static com.feishu._09DynamicProgramming.E08KnapsackProblem.print;

/**
 * @version v1.0
 * @author OldGj 2024/12/17
 * @apiNote 494. 目标和
 */
public class E19findTargetSumWays {
    /*
        01背包应用之“有多少种不同的填满背包最大容量的方法“
        nums = [1,1,1,1,1]  target = 3
        size = (5 + 3)/2 = 4

            0   1   2   3   4
        1   1   1   0   0   0
        1   1   2   1   0   0
        1   1   3   3   1   0
        1   1   4   6   4   1
        1   1   5   10  10  5
     */
    public int findTargetSumWays(int[] nums, int target) {
        /*
            假设加法的总和为x，那么减法对应的总和就是sum - x。
            所以我们要求的是 x - (sum - x) = target
                          x = (target + sum) / 2
            此时问题就转化为，用nums装满容量为x的背包，有几种方法。
         */
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(target)) {
            return 0;
        }
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        // size就是背包容量
        int size = (sum + target) >>> 1;
        int x = nums.length;
        int y = size + 1;
        int[][] dp = new int[x][y];
        // 初始化最上行
        if (nums[0] <= size) {
            dp[0][nums[0]] = 1;
        }
        int numZeros = 0; // 记录0的个数
        // 初始化最左列
        // 当从nums数组的索引0到i的部分有n个0时（n > 0)，每个0可以取+/-，因此有2的n次方个可以取到j = 0的方案
        // n = 0说明当前遍历到的数组部分没有0全为正数，因此只有一种方案可以取到j = 0（就是所有数都不取）
        for (int i = 0; i < x; i++) {
            if (nums[i] == 0) {
                numZeros++;
            }
            dp[i][0] = (int) Math.pow(2, numZeros);
        }
        // 递推公式分析：
        // 当nums[i] > j时，这时候nums[i]一定不能取，所以是dp[i - 1][j]种方案数
        // nums[i] <= j时，num[i]可取可不取，因此方案数是dp[i - 1][j] + dp[i - 1][j - nums[i]]
        // 由递推公式可知，先遍历i或j都可
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }
        print(dp);
        return dp[x - 1][y - 1];
    }


    public static void main(String[] args) {
        new E19findTargetSumWays().findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1);
    }
}
