package com.tyut._05doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/04/06
 * @apiNote 18. 四数之和
 */
public class E09fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(4, 0, nums.length - 1, target, nums,
                new LinkedList<>(), result);
        return result;
    }

    private void dfs(int n, int i, int j, int target, int[] nums,
                     LinkedList<Integer> stack, List<List<Integer>> result) {
        if (n == 2) {
            // 两数之和
            twoSum(i, j, target, nums, stack, result);
            return;
        }
        for (int k = i; k < j; k++) {
            // 去重
            if (k > i && nums[k] == nums[k - 1]) {
                continue;
            }
            // 固定一个数，求n-1个数之和
            stack.push(nums[k]);
            dfs(n - 1, k + 1, j, target - nums[k], nums, stack, result);
            stack.pop();
        }

    }

    private void twoSum(int left, int right, int target, int[] nums,
                        LinkedList<Integer> stack, List<List<Integer>> result) {
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                ArrayList<Integer> list = new ArrayList<>(stack);
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) left++;
                while (left < right && nums[right] == nums[right + 1]) right--;
            }
        }
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 遍历i ~ nums.length
        for (int i = 0; i < nums.length; i++) { //固定一个数

            // nums[i] > target 直接返回, 剪枝操作
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {    // 对nums[i]去重
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) { // 固定第二个数

                if (j > i + 1 && nums[j] == nums[j - 1]) {  // 对nums[j]去重
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {  // 两数之和
                    // nums[k] + nums[i] + nums[left] + nums[right] > target int会溢出
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        // 对nums[left]和nums[right]去重
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}

