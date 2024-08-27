package com.algorithm.sort;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/04/07
 * @apiNote  <a href="https://javaguide.cn/cs-basics/algorithms/10-classical-sorting-algorithms.html#%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F-insertion-sort">
 *     3.插入排序
 *     </a>
 */
public class E03InsertionSort {
    public void insertionSort(int[] nums) {
        // 定义一个low指针，指向未排序区域的第一个数，默认从1开始，认为第一个数已经有序
        for (int notSortedFirstIndex = 1; notSortedFirstIndex < nums.length; notSortedFirstIndex++) {
            // 定义一个指针指向已排序区域的最后一个指针
            int sortedLastIndex = notSortedFirstIndex - 1;
            // 记录未排序区域的第一个值，用于后序插入
            int current = nums[notSortedFirstIndex];
            // 如果以排序区域的最后一个值大于未排序区域的第一个值，则将已排序区域的最后一个值向后移动
            while (sortedLastIndex >= 0 && nums[sortedLastIndex] > current) {
                nums[sortedLastIndex + 1] = nums[sortedLastIndex];
                sortedLastIndex--;
            }
            // 循环结束，说明已经找到插入位置
            if (sortedLastIndex != notSortedFirstIndex - 1) {
                // 上面的i是经过--以后不满足while条件退出循环，因此在插入时需要在i+1位置插入
                nums[sortedLastIndex + 1] = current;
            }
        }
    }

    public static void main(String[] args) {
        E03InsertionSort e03InsertionSort = new E03InsertionSort();
        int[] ints = {5, 4, 3, 2, 1};
        e03InsertionSort.insertionSort2(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }

    public void insertionSort2(int[] nums) {
        // i：未排序的第一个指针
        for (int i = 1; i < nums.length; i++) {
            // j：已排序的最后一个指针
            int j = i - 1;
            int base = nums[i];
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
    }


}
