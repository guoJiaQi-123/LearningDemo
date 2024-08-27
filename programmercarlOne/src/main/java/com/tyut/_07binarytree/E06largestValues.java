package com.tyut._07binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/5/2
 * @apiNote 515. 在每个树行中找最大值
 */
public class E06largestValues {

    // 深度优先遍历
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 深度优先遍历
        dfs(root, 0, res);
        return res;
    }

    /**
     * 深度优先遍历
     * @param node 节点
     * @param depth 当前高度
     * @param res 结果集合
     */
    private void dfs(TreeNode node, int depth, List<Integer> res) {
        if (node == null) {
            return;
        }
        int max = Integer.MIN_VALUE;
        // 如果当前节点的值大于最大值，则更新最大值
        if (node.val > max) {
            max = node.val;
        }
        // 如果结果集合中的元素小于等于此时的高度，说明这是第一次遍历到当前高度
        // 如果 res.size() == 0 ,depth == 0,说明还没有遍历根节点，此时结果集放入根节点
        // 如果 res.size() == 1 ,depth == 1,结果集放的一个是根节点，而当前高度为1，说明是第一次遍历当前高度
        // 每次都在第一次遍历当前高度时，向结果集合中加入元素，此时结果集合的下标表示高度
        if (res.size() <= depth) {
            res.add(max);
        }
        // 如果出现最大值大于当前高度原先存放的最大值，则更新
        if (res.get(depth) < max) {
            res.set(depth, max);
        }
        // 遍历左孩子
        dfs(node.left, depth + 1, res);
        // 遍历右孩子
        dfs(node.right, depth + 1, res);
    }


    // 广度优先遍历
    public List<Integer> largestValues(TreeNode root) {
        // 结果集合
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 层序遍历需要使用的队列数据结构
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 定义一个指针存储每一行的最大值，默认为整型最小值
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                // 记录最大值
                max = Math.max(max, polled.val);
                // 层序遍历，将子节点加入队列
                TreeNode left = polled.left;
                TreeNode right = polled.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            // 将每一层的最大值加入结果集合
            res.add(max);
        }
        return res;
    }
}
