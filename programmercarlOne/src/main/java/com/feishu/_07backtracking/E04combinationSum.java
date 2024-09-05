package com.feishu._07backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/9/4
 * @apiNote 39. 组合总和
 */
public class E04combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(0, candidates, target, path, res);
        return res;
    }

    private void dfs(int start, int[] candidates, int target, LinkedList<Integer> path, List<List<Integer>> res) {
        // 如果target为0，说明找到解
        if (0 == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target < candidate) {
                continue;   // 剪枝
            }
            path.push(candidate);
            dfs(i, candidates, target - candidate, path, res); //  // 关键点:不用i+1了，表示可以重复读取当前的数
            path.pop();
        }
    }
}
