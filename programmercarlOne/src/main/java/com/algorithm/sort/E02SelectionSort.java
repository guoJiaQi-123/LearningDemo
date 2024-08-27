package com.algorithm.sort;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/04/06
 * @apiNote
 * <a href="https://javaguide.cn/cs-basics/algorithms/10-classical-sorting-algorithms.html#%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F-selection-sort">
 *     2.选择排序
 * </a> */
public class E02SelectionSort {

    // 选择排序，每一轮循环结束时，将选择到的最大的的值交换到最右侧
    public void selectSort(int[] nums) {
        // 1. 选择轮数：a.length - 1
        // 2. 交换的索引right初始化为a.length - 1，每次递减，将选择到的最大值与right位置交换
        for (int right = nums.length - 1; right > 0; right--) {
            int max = right;
            for (int i = 0; i < right; i++) {
                if (nums[i] > nums[max]) {
                    max = i;
                }
            }
            // max 值发生了变化才交换，否则不需要交换
            if (max != right) {
                // 每一轮循环结束时，将选择到的最大的的值交换到最右侧
                int t = nums[max];
                nums[max] = nums[right];
                nums[right] = t;
            }
        }
    }


    /**
     * 选择排序
     * 每一轮循环结束时，将选择到的最小的的值交换到最左侧
     * <p>JavaGuide<p/>
     */
    public void selectionSort(int[] arr) {
        // 每一轮循环结束时，将选择到的最小的的值交换到最左侧 同上
        for (int left = 0; left < arr.length - 1; left++) {
            int minIndex = left;
            for (int j = left + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != left) {
                int tmp = arr[left];
                arr[left] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        E02SelectionSort e02SelectionSort = new E02SelectionSort();
        int[] ints = {5, 4, 3, 2, 1};
        e02SelectionSort.selectSort(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
