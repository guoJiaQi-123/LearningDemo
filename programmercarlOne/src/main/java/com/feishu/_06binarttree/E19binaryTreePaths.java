package com.feishu._06binarttree;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/8/17
 * @apiNote 257. 二叉树的所有路径
 */
public class E19binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>(); // 存最终的结果
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>(); // 作为结果中的路径
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode node, List<Integer> paths, List<String> res) {
        paths.add(node.val); // 前序遍历
        if (node.left == null && node.right == null) { // 遇到叶子节点
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1)); // 拼接最后一个值
            res.add(sb.toString());
        }
        // 递归和回溯是同时进行，所以要放在同一个花括号里
        if (node.left != null) {
            traversal(node.left, paths, res); // 左
            paths.remove(paths.size() - 1); // 回溯
        }
        if (node.right != null) {
            traversal(node.right, paths, res); // 右
            paths.remove(paths.size() - 1); // 回溯
        }
    }
}
