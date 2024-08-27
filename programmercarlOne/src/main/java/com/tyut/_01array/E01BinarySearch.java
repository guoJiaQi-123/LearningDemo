package com.tyut._01array;

/**
 * @author OldGj 2024/03/09
 * @version v1.0
 * @apiNote 704. 二分查找
 */
public class E01BinarySearch {

    /*
            主要二分查找有两种，区别在于区间边界条件的不同，其中一种为左闭右开，另一种为左闭右闭
            对于左闭右开边界条件，left == right 时是有意义的，仍需要进行判断
            对于左闭右闭边界条件，left == right 时是没有意义的，因为right指针指向的数已经不可能为target
     */

    // 左闭右开
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // right指针指向的数已经不可能为target
        while (left < right) {  // 此时的left == right 没有意义
            int mid = (left + right) >>> 1;
            if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 左闭右闭
    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 定义target在左闭右闭的区间里，[left, right]
        while (left <= right) { // left == right任然有意义，任然可能是target
            int mid = left + ((right - left) >>> 1); // 防止 (left + right)溢出
            if (target < nums[mid]) {
                right = mid - 1; // target在左区间，所以[left,mid-1]
            } else if (target > nums[mid]) {
                left = mid + 1; // target在右区间，所以[mid+1,right]
            } else {
                return mid; // 数组中找到目标值，直接返回下标
            }
        }
        return -1;
    }


    public int search2(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search3(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
