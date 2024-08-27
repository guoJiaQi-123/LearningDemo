package com.feishu._06binarttree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/8/15
 * @apiNote 111. 二叉树的最小深度
 */
public class E15minDepth {

    /*
        BFS层序遍历-核心思想：遇到第一个叶子节点返回的当前层数就是最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 遇到第一个叶子节点时就返回当时的层数，即为当前二叉树的最小深度
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return minDepth;
    }

    /*
        DFS深度优先遍历
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMinDepth = minDepth2(root.left); // 左孩子的最小深度
        int rightMinDepth = minDepth2(root.right); // 右孩子的最小深度
        // 如果当前节点左孩子为null，则返回右孩子的最小深度+1
        if (root.left == null) {
            return rightMinDepth + 1;
        }
        // 如果当前节点右孩子为null，则返回左孩子的最小深度+1
        if (root.right == null) {
            return leftMinDepth + 1;
        }
        // 如果左右孩子都不为null，则返回左右孩子中更小的最小深度+1
        return Math.min(leftMinDepth, rightMinDepth) + 1;
    }
}
