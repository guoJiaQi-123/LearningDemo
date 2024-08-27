package com.tyut._07binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/5/2
 * @apiNote 104. 二叉树的最大深度
 */
public class E09maxDepth {

    // 层序遍历
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                if (polled.left != null) {
                    queue.offer(polled.left);
                }
                if (polled.right != null) {
                    queue.offer(polled.right);
                }
            }

        }
        return depth;
    }

    // 深度优先遍历
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth2(root.left);
            int rightHeight = maxDepth2(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
