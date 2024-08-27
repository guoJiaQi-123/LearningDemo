package com.tyut._07binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/5/1
 * @apiNote 637. 二叉树的层平均值
 */
public class E04averageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        // 层序遍历需要的队列数据结构
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Double level = null;
            // 每一层节点个数
            int size = queue.size();
            // 每一层节点的总和
            Double sum = 0.0;
            // 每轮循环，将当前层的所有节点全部弹出，将下一层的所有节点全部入队
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                sum += polled.val;
                TreeNode left = polled.left;
                TreeNode right = polled.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }


    /**
     * dfs 深度优先遍历
     * @param root
     * @return
     */
    public List<Double> averageOfLevels2(TreeNode root) {
        // 维护两个集合，一个集合counts记录每一层节点个数，一个集合sums记录每一层节点总和
        List<Integer> counts = new ArrayList<>();
        List<Double> sums = new ArrayList<>();
        dfs(root, 0, counts, sums);
        List<Double> averages = new ArrayList<>();
        int size = sums.size();
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i) / counts.get(i));
        }
        return averages;
    }

    // 深度优先遍历
    public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
        if (root == null) {
            return;
        }
        // 如果当前层小于sums集合的长度，说明之前已经遍历过当前层的其他节点
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);// 求和
            counts.set(level, counts.get(level) + 1); // 节点数加1
        } else { // 否则，说明第一次遍历当前层
            sums.add(1.0 * root.val); // 添加新的一层的元素
            counts.add(1); // count为1
        }
        // 左孩子
        dfs(root.left, level + 1, counts, sums);
        // 右孩子
        dfs(root.right, level + 1, counts, sums);
    }
}
