package com.tyut.sort._08_counting_sort;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/4/29
 * @apiNote 计数排序
 */
public class CountSort {

    public static void countingSort(int[] nums) {
        int len = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] ints = new int[max + 1];
        for (int num : nums) {
            ints[num]++;
        }
        int k = 0;
        for (int i = 0; i < ints.length; i++) {
            while (ints[i] != 0) {
                nums[k] = i;
                k++;
                ints[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {5, 4, 3, 2, 1,1};
        countingSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
