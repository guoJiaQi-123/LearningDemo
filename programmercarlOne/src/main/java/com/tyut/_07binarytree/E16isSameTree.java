package com.tyut._07binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/5/4
 * @apiNote 100. 相同的树
 */
public class E16isSameTree {
    // 递归
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        // 通过上面的判断，这个判断如果为true一定是两个节点一个为null一个不为null，返回false
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        // 判断左子树是否是相同的
        boolean a = isSameTree(p.left, q.left);
        // 判断右子树是否是相同的
        boolean b = isSameTree(p.right, q.right);
        return a && b;
    }

    //迭代
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            // 弹出需要比较的两个节点进行比较
            TreeNode pNode = queue.poll();
            TreeNode qNode = queue.poll();
            if (pNode == null && qNode == null) {
                continue;
            }
            if (pNode == null || qNode == null || qNode.val != pNode.val) {
                return false;
            }
            // 将需要比较的两个节点依次放入队列
            queue.offer(pNode.left);
            queue.offer(qNode.left);
            queue.offer(pNode.right);
            queue.offer(qNode.right);
        }
        return true;
    }
}
