package com.algorithm.sort;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/04/06
 * @apiNote
 *     <a href="https://javaguide.cn/cs-basics/algorithms/10-classical-sorting-algorithms.html#%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F-bubble-sort">
 *          1.冒泡排序
 *     </a>
 */
public class E01BubbleSort {


    // 冒泡排序非递归实现
    public int[] bubbleSort(int[] nums) {
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
        return nums;
    }


    /**
     * 递归 - 冒泡排序
     *
     * @param nums 待排序数组
     * @param j    未排序数据右边界
     */
    public void bubbleSort2(int[] nums, int j) {
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
        bubbleSort2(nums, x);
    }

    /**
     * 冒泡排序
     * JavaGuide
     */
    public static int[] bubbleSort3(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // Change flag，在一轮循环中只要发生交换，则flag置为false
                    flag = false;
                }
            }
            // 一轮都没有发生交换，没必要继续，直接退出循环
            if (flag) {
                break;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        E01BubbleSort e01BubbleSort = new E01BubbleSort();
        int[] ints = e01BubbleSort.bubbleSort(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(ints));
        int[] nums = new int[]{5, 4, 3, 2, 1};
        e01BubbleSort.bubbleSort2(nums, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);

    }

}
