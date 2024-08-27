package com.tyut._01array;


/**
 * @author OldGj 2024/03/11
 * @version v1.0
 * @apiNote 283. 移动零
 */
public class E08moveZeroes {
    /*
            1,12,0,3,0
                i
                j
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (slow < nums.length) {
            if (nums[slow] == 0) {
                while (fast < nums.length && nums[fast] == 0) {
                    fast++;
                }
                if (fast >= nums.length) {
                    break;
                }
                swap(nums, slow, fast);
                fast = slow;
            }
            slow++;
            fast++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
