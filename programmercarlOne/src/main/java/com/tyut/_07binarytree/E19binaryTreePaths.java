package com.tyut._07binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/5/8
 * @apiNote 257. 二叉树的所有路径
 */
public class E19binaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>(); // 结果集合，存放所有路径
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>(); // 单个路径
        doBinaryTreePaths(root, paths, res);
        return res;
    }

    private void doBinaryTreePaths(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val);
        if (root.right == null && root.left == null) { // 遇到叶子节点
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->"); // 拼接结果，不包括最后一个数据
            }
            sb.append(paths.get(paths.size() - 1)); // 拼接最后一个数据
            res.add(sb.toString());// 加入结果集合
            return;
        }
        if (root.left != null) {
            doBinaryTreePaths(root.left, paths, res); // 递归
            paths.remove(paths.size() - 1); // 回溯
        }
        if (root.right != null) {
            doBinaryTreePaths(root.right, paths, res); //递归
            paths.remove(paths.size() - 1); // 回溯
        }

    }

}
