package com.algorithm.sort;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/04/07
 * @apiNote <a href="https://javaguide.cn/cs-basics/algorithms/10-classical-sorting-algorithms.html#%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F-merge-sort">
 *     5.归并排序 [自上向下]
 *     </a>
 */
public class E05MergeSortTopDown {

    public static void main(String[] args) {
        E05MergeSortTopDown e05MergeSortTopDown = new E05MergeSortTopDown();
        int[] ints = {5, 4, 3, 2, 1};
        e05MergeSortTopDown.mergeSort(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }

    public void mergeSort(int[] nums) {
        int[] arr = new int[nums.length];
        /*
         * 参数一：待排序数组
         * 参数二：待排序数组的区域左标
         * 参数二：待排序数组的区域右标
         * 参数三：临时数组，用来合并数组时使用
         */
        split(nums, 0, nums.length - 1, arr);
    }

    private void split(int[] nums, int left, int right, int[] arr) {
        // 治
        if (left == right) {
            return;
        }
        // 分
        int mid = (left + right) >>> 1;
        split(nums, left, mid, arr);
        split(nums, mid + 1, right, arr);
        // 合
        merge(nums, left, mid, mid + 1, right, arr);
        System.arraycopy(arr, left, nums, left, right - left + 1);
    }

    /**
     * 合并有序数组
     *
     * @param nums 原始数组
     * @param i  iEnd 第一个有序范围
     * @param j  jEnd 第二个有序范围
     * @param arr 临时数组
     */
    private void merge(int[] nums, int i, int iEnd, int j, int jEnd, int[] arr) {
        // 定义一个指针k用于构建临时数组
        int k = i;
        while (i <= iEnd && j <= jEnd) {
            // 每次将 i ~ iEnd 或者 j ~ jEnd 中更小的数加入到临时数组，并将指针后移
            if (nums[i] < nums[j]) {
                arr[k] = nums[i];
                i++;
            } else {
                arr[k] = nums[j];
                j++;
            }
            k++;
        }
        // 当 i ~ iEnd 或 j ~ jEnd 其中一个区域的数据全部被加入到临时数组，则把另一个区域的数据拷贝到临时数组中
        if (i > iEnd) {
            System.arraycopy(nums, j, arr, k, jEnd - j + 1);
        }
        if (j > jEnd) {
            System.arraycopy(nums, i, arr, k, iEnd - i + 1);
        }
    }
}
