package com.feishu._07backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @version v1.0
 * @author OldGj 2024/9/11
 * @apiNote 491. 非递减子序列
 */
public class E10findSubsequences {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(0, nums);
        return res;
    }

    private void dfs(int startIndex, int[] nums) {
        // 题目说了，子集最少有两个元素，因此只要path.size大于1才添加
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        // 使用set去重，如果第一次访问一个值，则添加到set集合，如果第二次又遇到了这个值，set集合中存在，则跳过此次循环，达到去重的目的
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            int num = nums[i];
            //  如果path集合的最后一个元素比当前值num还大（不递增了），则跳出循环 || 当前值已经使用过了
            if (!path.isEmpty() && path.get(path.size() - 1) > num || set.contains(num)) {
                continue;
            }
            set.add(num); // 在set中记录当前元素已经出现过了
            path.add(num);
            dfs(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }

    static class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            dfs(0, nums);
            return res;
        }

        public void dfs(int start, int[] nums) {
            if (path.size() > 1) {
                res.add(new ArrayList<>(path));
            }
            // 使用数组去重，第一遇到一个值将对应数组下标置位1，如果再次遇到1，则说明已经访问过，跳过
            int[] used = new int[201];
            for (int i = start; i < nums.length; i++) {
                int num = nums[i];
                if (!path.isEmpty() && path.get(path.size() - 1) > num ||
                        used[num + 100] == 1) {
                    continue;
                }
                used[num + 100] = 1;
                path.add(num);
                dfs(i + 1, nums);
                path.remove(path.size() - 1);
            }
        }
    }
}
