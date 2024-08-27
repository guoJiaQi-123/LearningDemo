package com.tyut._01array;

/**
 * @author OldGj 2024/03/09
 * @version v1.0
 * @apiNote 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class E03SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        return new int[]{left, right};
    }

    /**
     * 寻找右边界
     *
     * @return 目标值最右边界索引
     */
    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int candidate = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                candidate = mid;
                left = mid + 1;
            }
        }
        return candidate;
    }

    /**
     * 寻找左边界
     *
     * @return 目标值最左边界索引
     */
    public int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int candidate = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                candidate = mid;
                right = mid - 1;
            }
        }
        return candidate;
    }
}
