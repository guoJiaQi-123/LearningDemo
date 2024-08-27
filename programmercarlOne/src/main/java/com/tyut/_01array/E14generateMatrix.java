package com.tyut._01array;

import java.util.Arrays;

/**
 * @author OldGj 2024/03/14
 * @version v1.0
 * @apiNote 59. 螺旋矩阵 II
 */
public class E14generateMatrix {

    public static void main(String[] args) {
        E14generateMatrix e14generateMatrix = new E14generateMatrix();
        int[][] ints = e14generateMatrix.generateMatrix(4);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1; // 填充的值
        int start = 0;
        int loop = n / 2;// 每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理
        int offset = 1; // 需要控制每一条边遍历的长度，每次循环右边界收缩一位
        int i, j;
        while (loop != 0) {
            // 模拟上边从左到右
            for (j = start; j < n - offset; j++) {
                res[start][j] = count++;
            }

            // 模拟右边从上到下
            for (i = start; i < n - offset; i++) {
                res[i][j] = count++;
            }

            //模拟下边从右到左
            for (; j >= offset; j--) {
                res[i][j] = count++;
            }
            //模拟左边从下到上
            for (; i >= offset; i--) {
                res[i][j] = count++;
            }
            start++;
            offset++;
            loop--;
        }
        if (n % 2 == 1) { // n 为奇数时，单独处理矩阵中心的值
            res[start][start] = count;
        }
        return res;
    }
}
