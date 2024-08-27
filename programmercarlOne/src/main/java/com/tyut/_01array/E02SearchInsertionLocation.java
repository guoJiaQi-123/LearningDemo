package com.tyut._01array;

/**
 * @author OldGj 2024/03/09
 * @version v1.0
 * @apiNote 35. 搜索插入位置
 */
public class E02SearchInsertionLocation {

    // 左闭右闭
    public int searchInsert(int[] nums, int target) {
        /*
                0   1   2   3
                    l
                r
                1   3   5   6
         */
        int left = 0;
        int right = nums.length - 1; // 定义target在左闭右闭的区间里，[left, right]
        while (left <= right) { // left==right，区间[left, right]依然有效
            int mid = left + ((right - left) >>> 1); // 防止溢出 等同于(left + right)/2
            if (target < nums[mid]) {
                right = mid - 1; // target 在左区间，所以[left, middle - 1]
            } else if (target > nums[mid]) {
                left = mid + 1; // target 在右区间，所以[middle + 1, right]
            } else {
                return mid;
            }
        }
        // 分别处理如下四种情况  退出循环，此时的left = right + 1
        // 目标值在数组所有元素之前  [0, -1]
        // 目标值等于数组中某一个元素  return middle;
        // 目标值插入数组中的位置 [left, right]，return  right + 1
        // 目标值在数组所有元素之后的情况 [left, right]， 因为是右闭区间，所以 return right + 1
        return right + 1;// 或者返回left
    }

    // 暴力
    public int searchInsert4(int[] nums, int target) {
        // 找到第一个大于等于target的元素，返回其下标即可，如果没有找到，返回数组长度
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    // 左闭右开
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // 定义target在左闭右开的区间里，[left, right)  target
        while (left < right) { // 因为left == right的时候，在[left, right)是无效的空间
            int mid = (left + right) >>> 1;
            if (target < nums[mid]) {
                right = mid; // target 在左区间，在[left, middle)中
            } else if (target > nums[mid]) {
                left = mid + 1; // target 在右区间，在 [middle+1, right)中
            } else {
                return mid; // 数组中找到目标值的情况，直接返回下标
            }
        }
        // 分别处理如下四种情况 此时的 right == left
        // 目标值在数组所有元素之前 [0,0)
        // 目标值等于数组中某一个元素 return middle
        // 目标值插入数组中的位置 [left, right) ，return right 即可
        // 目标值在数组所有元素之后的情况 [left, right)，因为是右开区间，所以 return right
        return right;
    }

    // ---------------------------------------------
    // 左闭右闭
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    // 左闭右开
    public int searchInsert3(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
