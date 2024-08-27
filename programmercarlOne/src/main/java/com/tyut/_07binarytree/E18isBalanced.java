package com.tyut._07binarytree;

import com.sun.security.auth.NTNumericCredential;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/5/6
 * @apiNote 110. 平衡二叉树
 */
public class E18isBalanced {

    // 递归一：
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                TreeNode left = polled.left;
                TreeNode right = polled.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
        }
        return depth;
    }


    // 递归法二
    public boolean isBalanced2(TreeNode root) {
        return getHeight(root) != -1;
    }

    /*
        获取node节点为根的二叉树的高度，如果该二叉树不是平衡二叉树，返回-1，如果是平衡二叉树，返回高度
     */
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left); // 右孩子的高度
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(node.right); // 左孩子的高度
        if (rightHeight == -1) {
            return -1;
        }
        // 如果不是平衡二叉树，返回-1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // 如果是平衡二叉树，返回高度
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
