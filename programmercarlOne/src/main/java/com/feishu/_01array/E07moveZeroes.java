package com.feishu._01array;

/**
 * @version v1.0
 * @author OldGj 2024/7/13
 * @apiNote 283. 移动零
 */
public class E07moveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) { // 将i指向的非0数放到j索引处
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        // 将j后面的全部置0
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            int n = nums.length, left = 0, right = 0;
            while (right < n) {
                if (nums[right] != 0) {
                    swap(nums, left, right); // 将左指针的零与右指针的非零数交换
                    left++;
                }
                right++;
            }
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

}
