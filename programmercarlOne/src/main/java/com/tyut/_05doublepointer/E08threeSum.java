package com.tyut._05doublepointer;

import java.util.*;

/**
 * @version v1.0
 * @author OldGj 2024/04/06
 * @apiNote 15. 三数之和
 */
public class E08threeSum {

    //回溯法
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(3, 0, nums.length - 1, 0, nums,
                new LinkedList<>(), res);
        return res;
    }

    private void dfs(int n, int i, int j, int target, int[] nums,
                     LinkedList<Integer> stack, List<List<Integer>> res) {
        if (n == 2) {
            towSum(i, j, target, nums, stack, res);
            return;
        }
        // 遍历i~j之间的每一个值
        for (int k = i; k < j; k++) {
            // 检查重复
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            // 固定一个数，再求n-1数之和
            stack.push(nums[k]);
            dfs(n - 1, k + 1, j, target - nums[k], nums, stack, res);
            stack.pop(); // 回溯
        }
    }

    public void towSum(int left, int right, int target, int[] nums,
                       LinkedList<Integer> stack, List<List<Integer>> res) {
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                List<Integer> list = new ArrayList<>(stack);
                list.add(nums[left]);
                list.add(nums[right]);
                res.add(list);
                left++;
                right--;
                // 去重
                while (left < right && nums[left] == nums[left - 1]) left++;
                while (left < right && nums[right] == nums[right + 1]) right--;
            }
        }
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int a = nums[i];
            if (a > 0) {
                return res;
            }
            //对a去重
            if (i > 0 && a == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = -a;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    // 去重
                    res.add(List.of(a, nums[left], nums[right]));
                    // 找下一个不重复的元素
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
