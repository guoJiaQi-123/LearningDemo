package com.feishu._07backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/9/11
 * @apiNote 47. 全排列 II
 */
public class E12permuteUnique {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(0, nums);
        return res;
    }

    private void dfs(int start, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            path.add(num);
            dfs(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}
