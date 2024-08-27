package com.tyut._01array;

/**
 * @author OldGj 2024/03/11
 * @version v1.0
 * @apiNote 26. 删除有序数组中的重复项
 */
public class E07removeDuplicates {
    public int removeDuplicates(int[] nums) {
        /*
                0,1,2,1,1,2,2,3,3,4
                      i
                          j
                                8

                                1   1
                                    i
                                    j

                0,1,2,3,4
         */
        if (nums.length == 1) {
            return 1;
        }
        int slow = 1;
        int fast = 1;
        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] == nums[fast - 1]) {
                fast++;
            }
            if (fast >= nums.length) {
                break;
            }
            nums[slow] = nums[fast];
            slow++;
            fast++;
        }
        return slow;
    }
    /*
                0,1,1,1,1,2,2,3,3,4
                  i
                  j
     */


    public int removeDuplicates3(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        // i指向下一个不重复元素，j指向当前元素
        int i = 1;
        for (int j = 1; j < len; j++) {
            if (nums[j] != nums[i - 1]) { // 找到了不重复元素
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        int fast = 1;
        int slow = 1;
        while (fast < len) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

}
