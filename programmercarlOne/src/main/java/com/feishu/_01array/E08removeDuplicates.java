package com.feishu._01array;

/**
 * @version v1.0
 * @author OldGj 2024/7/13
 * @apiNote 26. 删除有序数组中的重复项
 */
public class E08removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        // i指针用于找不同元素，slow指针用于构建不重复的新数组
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }

    public int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
