package com.feishu._01array;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/7/15
 * @apiNote LCR 146. 螺旋遍历二维数组
 */
public class E14spiralArray {
    public int[] spiralArray(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return new int[]{};
        }
        int rows = array.length; // 行
        int columns = array[0].length; // 列
        int[] res = new int[rows * columns];
        int left = 0; // 左边界
        int right = columns - 1; // 右边界
        int top = 0; // 上边界
        int bottom = rows - 1; // 下边界
        int i = 0; // 控制填充数组的索引，每填充一个值，i++
        while (left <= right && top <= bottom) {
            // 循环不变量原则，遵循左闭右闭
            for (int column = left; column <= right; column++) {
                res[i++] = array[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                res[i++] = array[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    res[i++] = array[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    res[i++] = array[row][left];
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
