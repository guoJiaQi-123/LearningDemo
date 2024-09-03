package com.feishu._07backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/9/2
 * @apiNote 77. 组合
 */
public class E01combine {
        
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs2(1, n, k, path, res);
        return res;
    }

    private void dfs(int start, int n, int k, LinkedList<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // for循环的作用，固定第一个值，比如 1~4，分别固定1~4，如果start为2，则不会遍历到1
        for (int i = start; i <= n; i++) {
            path.push(i); // 记录
            dfs(i + 1, n, k, path, res);
            path.pop(); // 回溯
        }
    }

    private void dfs2(int start, int n, int k, LinkedList<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // for循环的作用，固定第一个值，比如 1~4，分别固定1~4，如果start为2，则不会遍历到1
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.push(i); // 记录
            dfs(i + 1, n, k, path, res);
            path.pop(); // 回溯
        }
    }

}