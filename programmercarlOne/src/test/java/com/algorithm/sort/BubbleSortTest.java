package com.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/04/09
 * @apiNote 冒泡排序
 */
public class BubbleSortTest {

    @Test
    public void testBubbleSort() {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        bubbleSort2(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public void bubbleSort(int[] nums) {
        // 未排序数据的右边界
        int j = nums.length - 1;
        do {
            //定义一个变量 x 记录未排序区域的右边界
            int x = 0;
            for (int i = 0; i < j; i++) {
                if (nums[i] > nums[i + 1]) { // 相邻元素中前面的元素大则交换
                    int t = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = t;
                    // 每次交换后，更新变量x,最后一次交换后x的值为经过一轮排序后新的右边界，优化代码
                    x = i;
                }
            }
            j = x;
        } while (j != 0);
    }

    /**
     * 递归冒泡排序
     * @param nums 待排序数组
     * @param j 未排序右边界
     */
    public void bubbleSort(int[] nums, int j) {
        if (j == 0) {
            return;
        }
        //定义一个变量 x 记录未排序区域的右边界
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (nums[i] > nums[i + 1]) {
                int t = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = t;
                // 每次交换以后，更新x <未排序数据的右边界> 的值
                x = i;
            }
        }
        bubbleSort(nums, x);
    }

    public static void bubbleSort2(int[] arr) {
        for (int i = 1; i < arr.length ; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // Change flag
                    flag = false;
                }
            }
            // 一轮都没有发生交换，没必要继续，直接退出循环
            if (flag) {
                break;
            }
        }
    }
}
