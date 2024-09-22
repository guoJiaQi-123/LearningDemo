package com.itheima.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <h3>3数之和</h3>
 */
public class SumLeetcode15 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> stack = new LinkedList<>();

     List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 先排序，方便去重
        dfs(3, 0, nums.length - 1, 0, nums);
        return result;
    }

    /**
     *
     * @param nSum 几数之和
     * @param i 右指针
     * @param j 左指针
     * @param target 目标值
     * @param nums 原数组
     */
     public void dfs(int nSum, int i, int j, int target, int[] nums) {
        if (nSum == 2) {
            // 套用两数之和求解
            twoSum(i, j, nums, target);
            return;
        }
        for (int k = i; k < j; k++) { // 循环固定第一个数
            // 检查重复，如果出现重复，则跳过
            if (k > i && nums[k] == nums[k - 1]) {
                continue;
            }
            // 固定一个数字，再尝试 nSum-1 数字之和
            stack.push(nums[k]);
            dfs(nSum - 1, k + 1, j, target - nums[k], nums);
            stack.pop();
        }
    }


     public void twoSum(int i, int j, int[] numbers, int target) {
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else { // 找到解
                ArrayList<Integer> list = new ArrayList<>(stack);
                list.add(numbers[i]);
                list.add(numbers[j]);
                result.add(list);
                // 继续查找其它的解
                i++;
                j--;
                // 去重
                while (i < j && numbers[i] == numbers[i - 1]) {
                    i++;
                }
                while (i < j && numbers[j] == numbers[j + 1]) {
                    j--;
                }
            }
        }
    }
}
