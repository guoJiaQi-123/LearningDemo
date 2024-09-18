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
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> stack = new LinkedList<>();
    boolean[] visited;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // 排序，将相同的元素相邻放置
        visited = new boolean[candidates.length];
        dfs(0, candidates, target);
        return result;
    }

    public void dfs(int start, int[] candidates, int target) {
        if (target == 0) {
            result.add(new LinkedList<>(stack));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target < candidate) {
                continue; // 减枝
            }
            // 如果相邻的两个值相等，且前一个值还没有被访问，则跳过循环
            // （相邻的值只有一个可以被先访问，防止组合结果出现重复）比如：【521，512】
            if (i > 0 && candidate == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            stack.push(candidate);
            // 不同点，从当前遍历到的元素后面开始递归，start = i+1;排除自身（使得结果中一个元素只能出现一次）
            dfs(i + 1, candidates, target - candidate);
            stack.pop();
            visited[i] = false;
        }
    }

}
