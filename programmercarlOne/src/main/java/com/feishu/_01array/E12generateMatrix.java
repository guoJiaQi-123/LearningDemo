package com.feishu._01array;

/**
 * @version v1.0
 * @author OldGj 2024/7/15
 * @apiNote 59. 螺旋矩阵 II
 */
public class E12generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0; // 控制行
        int j = 0; // 控制列
        int count = 1; // 填充的值
        int loop = n / 2; //每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理
        int start = 0; // 每一圈的起始位置
        int offset = 1;// 需要控制每一条边遍历的长度，每次循环右边界收缩一位
        while (loop > 0) { // 一个while循环是模拟填充了一圈
            // 模拟上边从左到右，从start开始，到 n-offset 为止，每填充一个，count++
            for (j = start; j < n - offset; j++) {
                res[start][j] = count++;
            }
            // 模拟右边从上到下，从start行开始，到n-offset行结束
            for (i = start; i < n - offset; i++) {
                res[i][j] = count++;
            }
            // 模拟下边从右到左
            for (; j >= offset; j--) {
                res[i][j] = count++;
            }
            // 模拟右边从下到上
            for (; i >= offset; i--) {
                res[i][j] = count++;
            }
            // 填充一圈完成后
            start++; // 起始位置++ 之前是[0,0]位置，下一圈的起始位置就是[1,1]
            offset++; // 每填充一圈，下一圈的右边界就要收缩一位
            loop--;
        }
        if (n % 2 != 0) { // n 为奇数时，单独处理矩阵中心的值
            res[start][start] = count;
        }
        return res;
    }
}
