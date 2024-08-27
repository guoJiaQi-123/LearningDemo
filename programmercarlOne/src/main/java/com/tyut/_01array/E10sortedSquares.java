package com.tyut._01array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author OldGj 2024/03/12
 * @version v1.0
 * @apiNote 977. 有序数组的平方
 */
public class E10sortedSquares {
    // 暴力
    public int[] sortedSquares(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num * num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = queue.poll();
        }
        return nums;
    }

    public static void main(String[] args) {
        E10sortedSquares e10sortedSquares = new E10sortedSquares();
        int[] ints = {-4, -4, -3};
        int[] ints1 = e10sortedSquares.sortedSquares2(ints);
        System.out.println(Arrays.toString(ints1));
    }

    // 双指针 找中间的分界线，定义指针向外扩
    public int[] sortedSquares2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        if (nums.length == 1) {
            return nums;
        }
        int i = 1;
        // 找分界线
        while (i < nums.length && nums[i] <= nums[i - 1]) {
            i++;
        }
        // 从0-j递减 从i-length递增
        int j = i - 1;
        int[] ints = new int[nums.length];
        for (int k = 0; k < ints.length; k++) {
            if (j < 0 || i >= nums.length) {
                break;
            }
            if (nums[i] <= nums[j]) {
                ints[k] = nums[i];
                i++;
            } else if (nums[i] > nums[j]) {
                ints[k] = nums[j];
                j--;
            }
        }
        // i-length有剩余
        while (i < nums.length) {
            ints[i] = nums[i];
            i++;
        }
        // 0-j有剩余
        while (j >= 0) {
            ints[nums.length - j - 1] = nums[j];
            j--;
        }
        return ints;
    }

    // 双指针
    // 核心思想：原数组平方后，最大值都在两边，定义两个指针分别指向数组头和数组尾，
    // 定义一个新数组存放最终结果，每次向新数组的尾部放入原始数组中指针指向的更大的元素，然后将指针向中间移动
    public int[] sortedSquares3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int i = 0;
        int j = nums.length - 1;
        int[] ints = new int[nums.length];
        // 操作新数组的指针
        int x = nums.length - 1;
        while (i <= j) {
            if (nums[i] > nums[j]) {
                ints[x] = nums[i];
                i++;
            } else {
                ints[x] = nums[j];
                j--;
            }
            x--;
        }
        return ints;
    }
}
