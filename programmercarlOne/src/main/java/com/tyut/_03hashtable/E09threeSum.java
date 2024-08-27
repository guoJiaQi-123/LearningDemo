package com.tyut._03hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author OldGj 2024/03/25
 * @version v1.0
 * @apiNote 15. 三数之和
 */
public class E09threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            // 如果a已经大于0，那么nums[left]和nums[right]一定都大于0，三数和不可能为0
            if (a > 0) {
                return res;
            }
            if (i > 0 && a == nums[i - 1]) { // 去重 a
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = a + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(List.of(a, nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (left < right && nums[left] == nums[left + 1]) left++; // 去重b
                    while (right > left && nums[right] == nums[right - 1]) right--; // 去重c
                    left++;
                    right--;
                }
            }
        }
        return res;
    }

    // 方法二： 三数之和 - 回溯
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        dfs(3, 0, nums.length - 1, 0, nums,
                new LinkedList<>(), result);
        return result;
    }

    public void dfs(int n, int i, int j, int target, int[] nums,
                    LinkedList<Integer> stack, List<List<Integer>> res) {
        if (n == 2) {
            towSum(i, j, target, nums, stack, res);
            return;
        }
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

    // 两数之和
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
                while (left < right && nums[left] == nums[left - 1]) left++;
                while (left < right && nums[right] == nums[right + 1]) right--;
            }
        }

    }
}
