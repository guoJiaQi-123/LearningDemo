package com.feishu._07backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/9/4
 * @apiNote 40. 组合总和 II
 */
public class E05combinationSum2 {
    // 计算组合总和为目标值的所有组合
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 存储最终结果的列表
        List<List<Integer>> res = new ArrayList<>();
        // 存储当前路径的链表
        LinkedList<Integer> path = new LinkedList<>();
        // 对候选数字进行排序
        Arrays.sort(candidates);
        // 标记每个数字是否被使用
        boolean[] used = new boolean[candidates.length];
        Arrays.fill(used, false);
        // 开始深度优先搜索
        dfs(0, 0, candidates, target, res, path, used);
        return res;
    }

    // 深度优先搜索函数
    private void dfs(int start, int sum, int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> path, boolean[] used) {
        if (sum > target) {
            return;
        }
        // 如果当前总和等于目标值，将当前路径添加到结果列表
        if (sum == target) {
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i < candidates.length; i++) {
            // 避免重复选择相同数字的情况   出现相同值并且前一个数不在当前路径中
            /*
                这段代码的目的是在深度优先搜索的过程中，避免重复处理相同的数字，以得到无重复的组合结果。
                具体解释如下：
                i > 0 ：确保我们不是在处理数组的第一个元素。
                candidates[i] == candidates[i - 1] ：表示当前元素和前一个元素值相等。
                !used[i - 1] ：表示前一个相同值没有在相同树层使用过
             */
            if (i > 0 && candidates[i] == candidates[i - 1]
                    &&
                    !used[i - 1]) {
                continue;
            }
            // 累加当前数字到总和
            sum += candidates[i];
            // 标记当前数字已使用
            used[i] = true;
            // 将当前数字加入路径
            path.push(candidates[i]);
            // 递归搜索下一层
            dfs(i + 1, sum, candidates, target, res, path, used);
            // 回溯：标记当前数字未使用
            used[i] = false;
            // 从路径中移除当前数字
            path.pop();
            // 减去当前数字，恢复总和
            sum -= candidates[i];
        }
    }
}
