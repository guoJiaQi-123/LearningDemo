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
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(1, k, n, 0, path, res);
        return res;
    }

    /**
     *
     * @param start 开始索引
     * @param k 个数
     * @param n 目标和
     * @param sum 当前和
     * @param path 路径
     * @param res 结果集合
     */
    private void dfs(int start, int k, int n, int sum, LinkedList<Integer> path, List<List<Integer>> res) {
        if (sum > n) {
            return; // 如果此时的sum已经大于n，则没必要再判断后面，剪枝
        }
        if (path.size() == k && sum == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            dfs(i + 1, k, n, sum, path, res);
            sum -= i; // 回溯
            path.removeLast(); // 回溯
        }
    }
}
