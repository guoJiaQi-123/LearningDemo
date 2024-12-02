package com.feishu._09DynamicProgramming;


import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author OldGj 2024/02/22
 * @version v1.0
 * @apiNote 钢条切割问题 - 动态规划
 */
public class E11CutRodProblem {
    /*
           钢条长度    1  2  3  4
           钢条价值    1  5  8  9

           0   1   2   3   4       钢条总长度 = 背包总容量
       1       1   11  111 1111
               (1) (2) (3) (4)
       2           11  111 1111
                   2   21  211
                           22
               (1) (5) (6) (10)
       3       1   11  111 1111
                   2   21  211
                       3   22
                           31
               (1) (5) (8) (10)
       4       1   11  111 1111
                   2   21  211
                       3   22
                           31
                           4
               (1) (5) (8) (10)
    */
    public static void main(String[] args) {
        System.out.println(cut2(new int[]{0, 1, 5, 8, 9}, 4));
    }

    /**
     *  钢条切割问题 - 动态规划
     * @param values 钢条价值
     * @param n 钢条总长度
     * @return 切割的最大价值
     */
    private static int cut2(int[] values, int n) {
        int[][] dp = new int[values.length][n + 1];
        for (int i = 1; i < values.length; i++) { // 循环物品重量-> 钢管价值
            for (int j = 1; j < n + 1; j++) { // 循环背包容量 -> 钢管长度
                if (j >= i) { // 放得下
                    // dp[i][j]=max(dp[i-1][j],当前物品价值+dp[i][j-物品重量])
                    dp[i][j] = Integer.max(dp[i - 1][j], values[i] + dp[i][j - i]);
                } else { // 放不下
                    dp[i][j] = dp[i - 1][j];
                }
            }
            print(dp);
        }
        return dp[values.length - 1][n];
    }

    /**
     *  降维处理
     * @param values 钢条价值
     * @param n 钢条总长度
     * @return 切割的最大价值
     */
    private static int cut(int[] values, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < values.length; i++) {
            for (int j = i; j < n + 1; j++) {
                dp[j] = Integer.max(dp[j], values[i] + dp[j - i]);
            }
        }
        return dp[n];
    }

    static void print(int[][] dp) {
        System.out.println("-".repeat(18));
        Object[] array = IntStream.range(0, dp[0].length + 1).boxed().toArray();
        System.out.printf(("%2d ".repeat(dp[0].length)) + "%n", array);
        for (int[] d : dp) {
            array = Arrays.stream(d).boxed().toArray();
            System.out.printf(("%2d ".repeat(d.length)) + "%n", array);
        }
    }
}
