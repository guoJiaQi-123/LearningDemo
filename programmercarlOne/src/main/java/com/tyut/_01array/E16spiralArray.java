package com.tyut._01array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author OldGj 2024/03/14
 * @version v1.0
 * @apiNote LCR 146. 螺旋遍历二维数组
 */
public class E16spiralArray {
    public int[] spiralArray(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;
        while (left <= right && top <= bottom) {
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
            left++;
            right--;
            top++;
            bottom--;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
