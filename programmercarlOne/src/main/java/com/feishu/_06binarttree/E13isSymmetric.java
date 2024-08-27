package com.feishu._06binarttree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/8/15
 * @apiNote 101. 对称二叉树
 */
public class E13isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return doIsSymmetric(root, root);
    }

    private boolean doIsSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true; // 两个都为null，返回true
        }
        if (left == null || right == null) {
            return false; // 只有一个为null，返回false
        }
        if (!Objects.equals(left.val, right.val)) {
            return false; // 若两节点值不相等，返回false
        }
        boolean a = doIsSymmetric(left.left, right.right);// 查看对称节点是否满足上面条件
        boolean b = doIsSymmetric(left.right, right.left);
        return a && b;
    }

    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            // 每次从队列中弹出的两个元素就是关于树轴对称的
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) { // 如果轴对称的两个数同时为null，则对称，继续比较
                continue;
            }
            // 如果出现轴对称的两个数只有一个为null或者两者的值不同，返回false
            if (left == null || right == null || !Objects.equals(left.val, right.val)) {
                return false;
            }
            // 将对称的节点一对一对加入队列
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
