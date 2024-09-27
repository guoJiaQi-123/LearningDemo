package com.feishu._08greedy;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/9/27
 * @apiNote 122. 买卖股票的最佳时机 II
 */
public class E04maxProfit {
    public int maxProfit(int[] prices) {
        int[] profits = new int[prices.length - 1]; // 每天的利润数组，每天的利润数组从第二天开始算，比天数少1
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            profits[i - 1] = profit;
        }
        int res = 0;
        // 局部最优，将每天的利润是正的全部加起来
        for (int profit : profits) {
            if (profit > 0) {
                res += profit;
            }
        }
        // 全局最优，这些天所有的最大利润
        return res;
    }

    public int maxProfit2(int[] prices) {
        int[] profits = new int[prices.length - 1]; // 每天的利润数组，每天的利润数组从第二天开始算，比天数少1
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            profits[i - 1] = profit;
        }
        // 局部最优，将每天的利润是正的全部加起来
        // 全局最优，这些天所有的最大利润
        return Arrays.stream(profits)
                .filter(p -> p > 0) // 只取大于0的
                .sum(); // 求和
    }

    public static void main(String[] args) {
        new E04maxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
}
