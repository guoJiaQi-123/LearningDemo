package com.tyut._07binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                stringBuilder.append(paths.get(i)).append("->"); // 拼接结果，不包括最后一个数据
            }
            stringBuilder.append(paths.get(paths.size() - 1)); // 拼接最后一个数据
            res.add(stringBuilder.toString());// 加入结果集合
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
