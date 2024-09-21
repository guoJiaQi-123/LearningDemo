package com.feishu._07backtracking;

import java.util.*;

/**
 * @version v1.0
 * @author OldGj 2024/9/9
 * @apiNote 90. 子集 II
 */
public class E09subsetsWithDup {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            result.add(path);
            return result;
        }
        Arrays.sort(nums); // 排序
        used = new boolean[nums.length];
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int startIndex) {
        // 子集是收集树形结构中树的所有节点的结果。
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) { // 终止条件
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            // 去重，递归树层去重，如果nums中有重复，则必须先访问前面的元素才能访问后面的元素
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                // 如果出现重复，前面一个还没访问，则跳出循环
                continue;
            }
            int num = nums[i];
            path.push(num);
            used[i] = true;
            dfs(nums, i + 1);
            path.pop();
            used[i] = false;
        }
    }

    static class solution{
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums.length == 0) {
                result.add(path);
                return result;
            }
            Arrays.sort(nums);
            dfs(nums, 0);
            return result;
        }

        private void dfs(int[] nums, int startIndex) {
            result.add(new ArrayList<>(path));
            if (startIndex >= nums.length) { // 终止条件
                return;
            }
            // 使用set进行去重，第一次遇到入set，再遇到如果set中存在则跳过
            Set<Integer> set = new HashSet<>();
            for (int i = startIndex; i < nums.length; i++) {
                int num = nums[i];
                if (set.contains(num)) {
                    continue;
                }
                set.add(num);
                path.push(num);
                dfs(nums, i + 1);
                path.pop();
            }
        }
    }
}
