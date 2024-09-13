package com.feishu._07backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/9/11
 * @apiNote 47. 全排列 II
 */
public class E12permuteUnique {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used; // 判断一个元素是否被访问

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        // 定义一个集合存放结果
        /******************************和46的区别*******************************/
        Arrays.sort(nums); // 排序
        /******************************和46的区别*******************************/
        doPermute(nums);
        return res;
    }

    private void doPermute(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            /******************************和46的区别*******************************/
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue; // 相邻元素如果相等且前一个元素还没有被处理，则跳过 【两个相邻元素只有一个可以先被处理，排除重复】
            }
            /******************************和46的区别*******************************/
            if (!used[i]) {
                path.push(nums[i]);
                used[i] = true;
                doPermute(nums); // 递归
                path.pop(); // 回溯
                used[i] = false;  // 回溯
            }
        }
    }
}
