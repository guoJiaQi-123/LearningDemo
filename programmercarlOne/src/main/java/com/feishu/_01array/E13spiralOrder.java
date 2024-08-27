package com.feishu._01array;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/7/15
 * @apiNote 54. 螺旋矩阵
 */
public class E13spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null) {
            return res;
        }
        int rows = matrix.length; // 行
        int columns = matrix[0].length; // 列
        int left = 0; // 左边界
        int right = columns - 1; // 右边界
        int top = 0; // 上边界
        int bottom = rows - 1; // 下边界
        while (left <= right && top <= bottom) {
            // 循环不变量原则，遵循左闭右闭
            for (int column = left; column <= right; column++) {
                res.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    res.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }
            // 模拟一圈，缩小边界
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
