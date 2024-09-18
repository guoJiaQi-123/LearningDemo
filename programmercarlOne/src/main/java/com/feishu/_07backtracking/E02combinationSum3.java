package com.feishu._07backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/9/3
 * @apiNote 216. 组合总和 III
 */
public class E02combinationSum3 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, k, n);
        return res;
    }

    private void dfs(int start, int k, int target) {
        if (target == 0 && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (target < i) {
                continue; // 剪枝
            }
            if (path.size() == k) {
                continue; // 剪枝
            }
            path.push(i);
            dfs(i + 1, k, target - i);
            path.pop();
        }
    }
}
