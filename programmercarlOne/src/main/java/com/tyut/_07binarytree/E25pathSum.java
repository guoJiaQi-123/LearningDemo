package com.tyut._07binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/5/16
 * @apiNote 113. 路径总和 II
 */
public class E25pathSum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        // 存放单个路径
        Stack<Integer> path = new Stack<>();
        doPathSum(root, targetSum, path);
        return res;
    }

    private void doPathSum(TreeNode root, int targetSum, Stack<Integer> path) {
        // 遍历到null，返回
        if (root == null) {
            return;
        }
        // 将当前遍历到的节点加入路径集合
        path.push(root.val);
        // 用目标数减去当前遍历到的节点的值
        targetSum -= root.val;
        // 如果当前遍历到的节点为叶子节点
        if (root.left == null && root.right == null) {
            // 并且当前目标数恰被减为0
            if (targetSum == 0) {
                // 将当前路径集合加入最终结果集合
                res.add(new ArrayList<>(path));
            }
        }
        // 如果当前遍历到的节点为非叶子节点，则继续递归，并在递归返回时对路径集合回溯
        if (root.left != null) {
            doPathSum(root.left, targetSum, path);
            path.pop();
        }
        if (root.right != null) {
            doPathSum(root.right, targetSum, path);
            path.pop();
        }
    }
}
