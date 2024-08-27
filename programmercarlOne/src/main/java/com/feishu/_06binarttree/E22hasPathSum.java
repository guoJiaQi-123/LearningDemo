package com.feishu._06binarttree;

import jdk.jfr.BooleanFlag;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/8/18
 * @apiNote 112. 路径总和
 */
public class E22hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        List<TreeNode> paths = new ArrayList<>(); // 记录每一条路径
        List<Integer> res = new ArrayList<>(); // 记录每一条路径和
        doHasPathSum(root, paths, res);
        return res.contains(targetSum); // 如果targetSum存在于路径和集合中返回true
    }

    private void doHasPathSum(TreeNode node, List<TreeNode> paths, List<Integer> res) {
        paths.add(node);
        // 如果当前节点是叶子节点，则记录路径和并且加入res集合中
        if (node.left == null && node.right == null) {
            int sum = 0;
            for (TreeNode path : paths) {
                sum += path.val;
            }
            res.add(sum);
        }
        if (node.left != null) {
            doHasPathSum(node.left, paths, res);
            paths.remove(paths.size() - 1); // 回溯
        }
        if (node.right != null) {
            doHasPathSum(node.right, paths, res);
            paths.remove(paths.size() - 1);
        }
    }

    /**
     * root节点为根的数中是否存在路径和为targetSum
     */
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
            // 已经找到
            return hasPathSum2(root.right, targetSum);
        }
        return false;
    }
}
