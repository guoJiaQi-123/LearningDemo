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

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs2(1, n, k);
        return res;
    }

    private void dfs(int start, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // for循环的作用，固定第一个值，比如 1~4，分别固定1~4，如果start为2，则不会遍历到1
        for (int i = start; i <= n; i++) {
            path.push(i); // 记录
            dfs(i + 1, n, k);
            path.pop(); // 回溯
        }
    }

    private void dfs2(int start, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // for循环的作用，固定第一个值，比如 1~4，分别固定1~4，如果start为2，则不会遍历到1
        // i <= n - (k - path.size()) + 1;
        // 剪枝：  缺的数字 > 备用数字
        // 缺的数字：k - path.size()  >  备用数字：n - i + 1
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.push(i); // 记录
            dfs2(i + 1, n, k);
            path.pop(); // 回溯
        }
    }

}
