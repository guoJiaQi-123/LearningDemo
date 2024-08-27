package com.tyut._01array;

/**
 * @author OldGj 2024/03/10
 * @version v1.0
 * @apiNote 27. 移除元素
 */
public class E06removeElement {
    /*
        3   2   2   3



        0,1,0,4,3,2,2,2
                  i
                      j
     */
    // 快慢指针，快指针扫描到与val不等，就和让满指针指向的索引处覆盖快指针指向的值，
    // 慢指针指向下一位置，快指针继续扫描
    public int removeElement2(int[] nums, int val) {
        int low = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[low] = nums[fast];
                low++;
            }
        }
        return low;
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int num : nums) {
            if (num == val) {
                count++;
            }
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int j = i;
            int num = nums[i];
            if (num == val) {
                while (j < len - 1 && nums[j] == val) {
                    j++;
                }
                swap(nums, i, j);
            }
        }
        return nums.length - count;
    }


    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
