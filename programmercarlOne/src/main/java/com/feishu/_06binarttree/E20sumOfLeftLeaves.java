package com.feishu._06binarttree;

import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/8/17
 * @apiNote 404. 左叶子之和
 */
public class E20sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        // 定义结果指针
        int sum = 0;
        // 定义一个栈数据结构用于前序遍历
        Stack<TreeNode> stack = new Stack<>();
        // 定义一个节点指针用于遍历
        TreeNode curr = root;
        // 定义一个指针记录是否为左节点
        TreeNode leftNode = null;
        // 前序遍历
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                // 如果遍历到的节点即是左节点又是叶子节点，则相加结果
                if (curr == leftNode && curr.left == null && curr.right == null) {
                    sum += curr.val;
                }
                stack.push(curr);
                curr = curr.left;
                // 记录左节点
                leftNode = curr;
            } else {
                TreeNode pop = stack.pop();
                curr = pop.right;
            }
        }
        return sum;
    }
}
