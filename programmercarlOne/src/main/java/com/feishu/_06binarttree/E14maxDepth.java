package com.feishu._06binarttree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/8/15
 * @apiNote 104. 二叉树的最大深度
 */
public class E14maxDepth {
    /*
        广度优先遍历-层序遍历
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0; // 定义一个遍历记录深度
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 每遍历一层，深度++，最大深度就是最大层数
            depth++;
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
        return depth;
    }

    /*
        深度优先遍历，后序遍历-先分别计算左右子树的最大深度
     */
    public int maxDepth2(TreeNode root) {
        // 遇到根节点返回0
        if (root == null) {
            return 0;
        }
        // 左子树的最大深度
        int leftDepth = maxDepth2(root.left);
        // 右子树的最大深度
        int rightDepth = maxDepth2(root.right);
        // 根节点的最大深度就是左子树或者右子树最大深度更大的加1
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
