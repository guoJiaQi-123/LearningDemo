package com.feishu._06binarttree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/8/17
 * @apiNote 222. 完全二叉树的节点个数
 */
public class E17countNodes {
    /*
        深度优先遍历，后序遍历，先求左子树的节点个数，再求右子树的节点个数
        总个数就是左子树的节点个数加右子树的节点个数加1
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left); // 左子树的节点个数
        int right = countNodes(root.right); // 右子树的节点个数
        return left + right + 1;
    }

    /*
        广度优先遍历-层序遍历，定义一个遍历记录节点个数
        因为层序遍历需要使用队列数据结构，而队列中的个数正好是每一层节点的个数
        因此只需要在遍历过程中将每一次队列中的个数累加即可
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 将每一层的节点个数累加
            res += size;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    // 利用完全二叉树的性质
    // 情况一：满二叉树 节点数 = 2 ^ 深度 - 1
    // 情况二：分别递归左孩子，和右孩子，递归到某一深度一定会有左孩子或者右孩子为满二叉树，然后依然可以按照情况1来计算。
    public int countNodes5(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0; // 左视图深度
        int rightDepth = 0; // 右视图深度
        // 计算左视图深度
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        // 计算右视图深度
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        // 如果左视图深度等于右视图深度，说明是一颗满二叉树
        if (leftDepth == rightDepth) {
            // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
            return (2 << leftDepth) - 1;
        }
        return countNodes5(root.left) + countNodes5(root.right) + 1;
    }
}
