package com.feishu._01array;

/**
 * @version v1.0
 * @author OldGj 2024/7/10
 * @apiNote 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class E01searchRange {


    public int[] searchRange(int[] nums, int target) {
        int leftBorder = searchLeft(nums, target);
        int rightBorder = searchRight(nums, target);
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }
        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        return new int[]{-1, -1};
    }

    private int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 循环不变量，左闭有闭
        int rightBorder = -2; // 记录一下rightBorder没有被赋值的情况
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else { // 寻找右边界，nums[middle] == target的时候更新left
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }


    public int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 循环不变量，左闭有闭
        int leftBorder = -2;  // 记录一下leftBorder没有被赋值的情况
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] >= target) { // 寻找左边界，在nums[mid]=target时任然更新right，继续在左部分找
                right = mid - 1;
                leftBorder = right;
            } else {
                left = mid + 1;
            }
        }
        return leftBorder;
    }

}
