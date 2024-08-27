package com.tyut.sort._06_quick_sort;

import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2024/04/24
 * @apiNote 快速排序 单边
 */
public class QuickSort1 {
    public void quickSort(int[] nums) {
        doQuickSort(nums, 0, nums.length - 1);
    }

    private void doQuickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(nums, left, right);
        doQuickSort(nums, left, p - 1);
        doQuickSort(nums, p + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pv = nums[right]; // 单边快排
        int i = left; // 找大的
        int j = left; // 找小的
        while (j < right) {
            if (nums[j] < pv) {
                if (i != j) {
                    swap(nums, i, j);
                }
                i++;
            }
            j++;
        }
        swap(nums, right, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        QuickSort1 quickSort1 = new QuickSort1();
        int[] ints = new int[]{5,4,3,2,1};
        quickSort1.quickSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
