package com.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @version v1.0
 * @author OldGj 2024/04/09
 * @apiNote 随机基准点+处理重复值 双边循环快速排序
 */
public class E06QuickSort3 {
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


    /*
        核心思想是
            * 改进前，i 只找大于的，j 会找小于等于的。一个不找等于、一个找等于，势必导致等于的值分布不平衡
            * 改进后，二者都会找等于的交换，等于的值会平衡分布在基准点两边
     */
    private int partition(int[] nums, int left, int right) {
        // 随机基准点
        int random = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(nums, left, random);
        // 基准点
        int pv = nums[left];
        int i = left + 1; // 在处理重复值时,i要从left + 1开始
        int j = right;
        while (i <= j) {
            // 处理重复值，i需要从左到右找大于等于基准点的值
            while (i <= j && nums[i] < pv) {
                i++;
            }
            // 处理重复值，j需要从右向左找小于等于基准点的值
            while (i <= j && nums[j] > pv) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, j, left);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        E06QuickSort3 e06QuickSort3 = new E06QuickSort3();
        int[] ints = {5, 4, 4, 4, 6, 5, 1, 2, 3, 3, 2};
        e06QuickSort3.quickSort(ints);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
