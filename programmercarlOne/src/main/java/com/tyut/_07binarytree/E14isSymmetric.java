package com.tyut._07binarytree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/5/3
 * @apiNote 101. 对称二叉树
 */
public class E14isSymmetric {
    public boolean isSymmetric(TreeNode root) {
     return doIsSymmetric(root, root);
    }

    private boolean doIsSymmetric(TreeNode left, TreeNode right) {
        // 若同时为 null
        if (left == null && right == null) {
            return true;
        }
        // 若有一个为 null (有上一轮筛选，另一个肯定不为 null)
        if (left == null || right == null) {
            return false;
        }
        // 若两节点值不相等，返回false
        if (!Objects.equals(left.val, right.val)) {
            return false;
        }
        boolean a = doIsSymmetric(left.left, right.right);
        boolean b = doIsSymmetric(left.right, right.left);
        return a && b;
    }

    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

}

