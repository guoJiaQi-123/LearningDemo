package com.feishu._09DynamicProgramming;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @version v1.0
 * @author OldGj 2024/11/14
 * @apiNote 0-1背包问题
 */
public class E08KnapsackProblem {
    static class Item {
        int index;
        String name;
        int weight;
        int value;

        public Item(int index, String name, int weight, int value) {
            this.index = index;
            this.name = name;
            this.weight = weight;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item(" + name + ")";
        }
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(1, "黄金", 4, 1600),
                new Item(2, "宝石", 8, 2400),
                new Item(3, "白银", 5, 30),
                new Item(4, "钻石", 1, 10_000),
        };
        System.out.println(select(items, 10));
    }

    static int select(Item[] items, int total) {
        int[][] dp = new int[items.length][total + 1];
        // 初始化第0行
        Item item0 = items[0];
        for (int j = 0; j < total + 1; j++) {
            if (j >= item0.weight) { // 装得下
                dp[0][j] = item0.value;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            Item item = items[i];
            for (int j = 1; j < total + 1; j++) {
                if (j >= item.weight) { // 装得下
                    dp[i][j] = Integer.max(dp[i - 1][j], item.value + dp[i - 1][j - item.weight]);
                } else { // 装不下 -> 沿用上一次
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][total];
    }

    static void print(int[][] dp) {
        System.out.println("   " + "-".repeat(63));
        Object[] array = IntStream.range(0, dp[0].length + 1).boxed().toArray();
        System.out.printf(("%5d ".repeat(dp[0].length)) + "%n", array);
        for (int[] d : dp) {
            array = Arrays.stream(d).boxed().toArray();
            System.out.printf(("%5d ".repeat(d.length)) + "%n", array);
        }
    }
}
