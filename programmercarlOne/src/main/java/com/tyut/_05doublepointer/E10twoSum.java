package com.tyut._05doublepointer;

/**
 * @version v1.0
 * @author OldGj 2024/9/22
 * @apiNote 167. 两数之和 II - 输入有序数组
 */
public class E10twoSum {
    /*
        思路
            - 两个指针i和j分别指向最左侧和最右侧的数字
            - 它俩指向的数字和与target相比
                - 小于target i++向右找
                - 大于target j--向左找
                - 等于target找到
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                break;
            }
        }
        return new int[]{i + 1, j + 1};
    }
}
