package com.tyut._07binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/5/14
 * @apiNote 112. 路径总和
 */
public class E22hasPathSum {


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 定义一个集合用于存放每一条从根节点到叶子节点的路径
        List<TreeNode> path = new ArrayList<>();
        // 定义一个res集合用于存放每一条路径的和
        List<Integer> res = new ArrayList<>();
        doHasPathSum(root, path, res);
        // 如果target存在res集合，返回true否则返回false
        return res.contains(targetSum);
    }


    private void doHasPathSum(TreeNode root, List<TreeNode> path, List<Integer> res) {
        path.add(root);
        // 如果当前遍历到的节点为叶子节点
        if (root.left == null && root.right == null) {
            // 计算路径和并且加入res集合中
            int sum = 0;
            for (TreeNode treeNode : path) {
                sum += treeNode.val;
            }
            res.add(sum);
        }
        // 如果当前节点的左孩子不为null，递归左孩子，并且在递归后回溯
        if (root.left != null) {
            doHasPathSum(root.left, path, res);
            path.remove(path.size() - 1); // 回溯
        }
        // 如果当前节点的右孩子不为null，递归右孩子，并且在递归后回溯
        if (root.right != null) {
            doHasPathSum(root.right, path, res);
            path.remove(path.size() - 1); // 回溯
        }
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 每次递归用目标数减去当前节点的值
        targetSum -= root.val;
        // 当遍历到叶子节点的同时，目标数刚好为0，说明存在这样的路径
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        // 当遍历到的节点为非叶子节点时 * 必须先左
        if (root.left != null) {
            // 递归遍历左子树
            boolean left = hasPathSum2(root.left, targetSum);
            if (left) {
                return true;
            }
        }
        // 递归遍历右子树
        if (root.right != null) {
            boolean right = hasPathSum2(root.right, targetSum);
            if (right) {     // 已经找到
                return true;
            }
        }
        return false;
    }
}
