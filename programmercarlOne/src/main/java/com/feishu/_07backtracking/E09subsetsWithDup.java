package com.feishu._07backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        Arrays.sort(nums);
        used = new boolean[nums.length];
        dfs(nums, 0);
        return result;
    }

    private void dfs(int[] nums, int startIndex) {
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
}
