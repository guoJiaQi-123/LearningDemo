package com.feishu._07backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/9/11
 * @apiNote 46. 全排列
 */
public class E11permute {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    boolean[] used; // 判断一个元素是否被访问

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        // 当收集元素的数组path的大小达到和nums数组一样大的时候，说明找到了一个全排列
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) { // 只有在元素没有被访问的情况下才做选择
                used[i] = true;
                path.add(nums[i]);
                dfs(nums);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
