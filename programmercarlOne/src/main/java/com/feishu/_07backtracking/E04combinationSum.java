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
        dfs(0, candidates, target, 0, path, res);
        return res;
    }

    private void dfs(int start, int[] candidates, int target, int sum, LinkedList<Integer> path, List<List<Integer>> res) {
        if (sum> target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            sum += candidate;
            path.push(candidate);
            dfs(i, candidates, target, sum, path, res); //  // 关键点:不用i+1了，表示可以重复读取当前的数
            path.pop();
            sum -= candidate;
        }
    }
}
