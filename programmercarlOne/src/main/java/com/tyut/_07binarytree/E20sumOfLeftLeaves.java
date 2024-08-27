package com.tyut._07binarytree;

import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/5/9
 * @apiNote 404. 左叶子之和
 */
public class E20sumOfLeftLeaves {


    public int sumOfLeftLeaves2(TreeNode root) {
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
                // 如果遍历到的节点既是左节点又是叶子节点，则相加结果
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

    // 递归法
    public int sumOfLeftLeaves(TreeNode root) {
        /*
            递归的终止条件 ： 1. 如果当前节点为null，返回0
                           3. 如果当前节点的左孩子为左叶子节点，记录左叶子的值
        */
        if (root == null) {
            return 0;
        }
        int mid = 0;
        // 当前遍历到的节点的左孩子为左叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            // 记录左叶子的值
            mid = root.left.val;
        }
        // 递归求左孩子的左叶子之和
        int left = sumOfLeftLeaves(root.left);
        // 右孩子的左叶子之和
        int right = sumOfLeftLeaves(root.right);

        // 返回左叶子的值+左孩子的左叶子之和+右孩子的左叶子之和
        return mid + left + right;
    }


}
