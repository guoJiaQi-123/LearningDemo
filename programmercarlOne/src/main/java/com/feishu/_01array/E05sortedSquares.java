package com.feishu._01array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @version v1.0
 * @author OldGj 2024/7/13
 * @apiNote 977. 有序数组的平方
 */
public class E05sortedSquares {

    /*
        暴力方法：先将数组循环一次，将所有数组元素的值平方作为当前索引下的新值
        对数组排序，返回新数组
     */
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }


    // 双指针 找中间的分界线，定义指针向外扩
    public int[] sortedSquares2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        if (nums.length == 1) {
            return nums;
        }
        int right = 1;
        // 找分界线
        while (right < nums.length && nums[right] <= nums[right - 1]) {
            right++;
        }
        // 从0-j递减 从i-length递增
        int left = right - 1;
        int[] ints = new int[nums.length];
        for (int k = 0; k < ints.length; k++) {
            if (left < 0 || right >= nums.length) {
                break;
            }
            if (nums[right] <= nums[left]) {
                ints[k] = nums[right];
                right++;
            } else if (nums[right] > nums[left]) {
                ints[k] = nums[left];
                left--;
            }
        }
        // right-length有剩余
        while (right < nums.length) {
            ints[right] = nums[right];
            right++;
        }
        // 0-j有剩余
        while (left >= 0) {
            ints[nums.length - left - 1] = nums[left];
            left--;
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
        int left = 0;
        int right = nums.length - 1;
        int[] ints = new int[nums.length];
        // 操作新数组的指针
        int x = nums.length - 1;
        while (left <= right) {
            if (nums[left] > nums[right]) {
                ints[x] = nums[left];
                left++;
            } else {
                ints[x] = nums[right];
                right--;
            }
            x--;
        }
        return ints;
    }

    /*
        优先级队列
     */
    public int[] sortedSquares4(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num * num); // 入队
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = queue.poll(); // 出队
        }
        return nums;
    }
}
