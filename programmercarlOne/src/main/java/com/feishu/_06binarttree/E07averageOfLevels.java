package com.feishu._06binarttree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/8/14
 * @apiNote 637. 二叉树的层平均值
 */
public class E07averageOfLevels {
    /*
        bfs，层序遍历，定义一个变量记录每一层的累加和，然后计算层平均值
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0; // 定义一个sum记录每一层的累加和
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                sum += node.val;
            }
            // sum为这一层所有元素之和，size为这一层的元素个数，sum/size即为当前层平均值
            res.add(sum / size);
        }
        return res;
    }

    /**
     * dfs 深度优先遍历，维护两个集合，一个集合counts记录每一层节点个数，一个集合sums记录每一层节点总和
     * 遍历每个节点时，都更新这两个集合在这一层的数据，记录节点个数的集合+1，记录累加和的集合将当前节点的值累加
     * 最后通过记录的节点个数和累加和计算每层节点的平均值
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
