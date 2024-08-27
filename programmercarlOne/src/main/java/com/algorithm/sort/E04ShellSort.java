package com.algorithm.sort;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/04/07
 * @apiNote  <a href="https://javaguide.cn/cs-basics/algorithms/10-classical-sorting-algorithms.html#%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F-shell-sort">
 *     4.希尔排序
 *     </a>
 */
public class E04ShellSort {


    /*
        希尔排序的基本思想是：先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
                          待整个序列中的记录 “基本有序” 时，再对全体记录进行依次直接插入排序。
     */
    public void shellSort(int[] nums) {
        for (int gap = nums.length >> 1; gap >= 1; gap = gap >> 1) {
            // notSortedFirstIndex 未排序数组的第一个指针
            for (int notSortedFirstIndex = gap; notSortedFirstIndex < nums.length; notSortedFirstIndex++) {
                // 未排序区域的第一个元素值
                int current = nums[notSortedFirstIndex];
                int sortedLastIndex = notSortedFirstIndex - gap; // 排序数组的最后一个数据指针
                while (sortedLastIndex >= 0 && nums[sortedLastIndex] > current) {
                    nums[sortedLastIndex + gap] = nums[sortedLastIndex];
                    sortedLastIndex -= gap;
                }
                if (sortedLastIndex != notSortedFirstIndex - gap) {
                    nums[sortedLastIndex + gap] = current;
                }
            }
        }
    }

    /**
     * 希尔排序
     * JavaGuide
     */
    public void shellSort2(int[] arr) {
        int gap = arr.length >> 1;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                // 未排序区域的第一个元素值
                int current = arr[i];
                // 已排序区域的最后一个元素指针
                int preIndex = i - gap;
                // Insertion sort
                while (preIndex >= 0 && arr[preIndex] > current) {
                    // 后移
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = current;

            }
            gap = gap >> 1;
        }
    }


    public static void main(String[] args) {
        E04ShellSort e04ShellSort = new E04ShellSort();
        int[] ints = {5, 4, 3, 2, 1};
        e04ShellSort.shellSort4(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }

    public void shellSort3(int[] arr) {
        int gap = arr.length >> 1;
        while (gap > 0) {
            for (int notSortedFirstIndex = gap; notSortedFirstIndex < arr.length; notSortedFirstIndex++) {
                int sortedLastIndex = notSortedFirstIndex - gap;
                int current = arr[notSortedFirstIndex];
                while (sortedLastIndex >= 0 && arr[sortedLastIndex] > current) {
                    arr[sortedLastIndex + gap] = arr[sortedLastIndex];
                    sortedLastIndex -= gap;
                }
                if (sortedLastIndex != notSortedFirstIndex - gap) {
                    arr[sortedLastIndex + gap] = current; // 插入
                }
            }
            gap = gap >> 1;
        }
    }


    public void shellSort4(int[] arr) {
        int gap = arr.length >>> 1;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int base = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > base) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = base;
            }
            gap /= 2;
        }
    }


}
