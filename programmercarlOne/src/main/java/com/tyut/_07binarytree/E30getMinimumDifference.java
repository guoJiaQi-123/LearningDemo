package com.tyut._07binarytree;

import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/6/13
 * @apiNote 530. 二叉搜索树的最小绝对差
 */
public class E30getMinimumDifference {

    /**
     * 利用二叉搜索树的中序遍历是递增序列的特点，通过查找中序遍历两两节点的最小值，即为二叉搜索树的最小绝对值
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        int resMin = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null; // 中序遍历到的当前节点的前一个节点
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                // 中序遍历
                if (prev != null) {
                    resMin = Math.min(resMin, pop.val - prev.val);
                }
                // 用pre节点记录cur节点的前一个节点
                prev = pop;
                curr = pop.right;
            }
        }
        return resMin;
    }


    /**
     * 递归做法
     */
    static class Solution {
        TreeNode pre;// 记录上一个遍历的结点
        int result = Integer.MAX_VALUE;

        public int getMinimumDifference(TreeNode root) {
            if (root == null) return 0;
            traversal(root);
            return result;
        }

        public void traversal(TreeNode root) {
            if (root == null) return; // 递归的结束条件
            //左
            traversal(root.left);
            //中
            if (pre != null) {
                result = Math.min(result, root.val - pre.val);
            }
            pre = root;  // 用pre节点记录cur节点的前一个节点
            //右
            traversal(root.right);
        }
    }
}
