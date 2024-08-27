package com.tyut._07binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/5/3
 * @apiNote 226. 翻转二叉树
 */
public class E11invertTree {

    // 递归实现 前序遍历
    public TreeNode invertTree(TreeNode root) {
        doInvertTree(root);
        return root;
    }

    // 递归函数
    public void doInvertTree(TreeNode node) {
        if (node == null) {
            return;
        }
        swap(node);
        // 反转左孩子
        doInvertTree(node.left);
        // 反正右孩子
        doInvertTree(node.right);
    }

    // 迭代实现 前序遍历
    public TreeNode invertTree2(TreeNode root) {
        // 前序遍历需要的栈数据结构
        Stack<TreeNode> stack = new Stack<>();
        // 定义指针操作该树
        TreeNode curr = root;
        // 如果当前节点不为null或者栈不为空
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                // 前序遍历消费节点，交换父节点的左右孩子
                swap(curr);
                // 节点入栈
                stack.push(curr);
                // 指向左孩子
                curr = curr.left;
            } else {
                // 节点为null，说明当前节点左孩子已经被消费
                TreeNode pop = stack.pop();
                // 弹栈后指向右孩子   中 -> 左 -> 右
                curr = pop.right;
            }
        }
        return root;
    }

    // 迭代实现2 前序遍历 另一种写法
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 前序遍历需要的栈数据结构
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop(); // 中
            swap(pop);
            // 此时的入栈顺序为 中 - 右 - 左   则出栈顺序为 中 - 左 - 右
            if (pop.right != null) {
                stack.push(pop.right); // 右
            }
            if (pop.left != null) {
                stack.push(pop.left); // 左
            }
        }
        return root;
    }

    // 迭代遍历 层序遍历
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 层序遍历需要的队列数据结构
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 队列的长度就是每一层节点的个数
            int size = queue.size();
            // 遍历每一层的节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 消费节点 => 翻转左右孩子
                swap(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    /**
     * 交换父节点的左右孩子
     * @param node 父节点
     */
    private void swap(TreeNode node) {
        TreeNode treeNode = node.left;
        node.left = node.right;
        node.right = treeNode;
    }
}
