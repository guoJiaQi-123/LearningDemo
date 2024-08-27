package com.tyut._03hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author OldGj 2024/03/25
 * @version v1.0
 * @apiNote 18. 四数之和
 */
public class E10fourSum {

    /*
        力扣中有大数据量的测试，因此有时候需要将target定义为long数据类型
     */
    // 回溯法 - 一套代码可求 2数之和，3数之和，4数之和 ...
    public List<List<Integer>> fourSum(int[] nums, long target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(4, 0, nums.length - 1, target, nums,
                new LinkedList<>(), result);
        return result;
    }

    private void dfs(int n, int i, int j, long target, int[] nums,
                     LinkedList<Integer> stack, List<List<Integer>> res) {
        if (n == 2) {
            // 两数之和
            towSum(i, j, target, nums, stack, res);
            return;
        }
        for (int k = i; k < j; k++) {
            if (k > i && nums[k] == nums[k - 1]) { // 去重
                continue;
            }
            // 固定一个数，再求n-1数之和
            stack.push(nums[k]);
            dfs(n - 1, k + 1, j, target - nums[k], nums, stack, res);
            stack.pop();
        }
    }

    private void towSum(int left, int right, long target, int[] nums, LinkedList<Integer> stack,
                        List<List<Integer>> res) {
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                List<Integer> list = new ArrayList<>(stack);
                list.add(nums[left]);
                list.add(nums[right]);
                res.add(list);
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) left++;
                while (left < right && nums[right] == nums[right + 1]) right--;
            }
        }
    }
}
