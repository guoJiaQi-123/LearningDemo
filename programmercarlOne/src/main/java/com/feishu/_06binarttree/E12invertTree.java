package com.feishu._06binarttree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/8/15
 * @apiNote 226. 翻转二叉树
 */
public class E12invertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        doInvertTree(root);
        return root;
    }

    private void doInvertTree(TreeNode node) {
        if (node == null) {
            return;
        }
        swap(node); // 交换node节点的左右孩子
        doInvertTree(node.left);
        doInvertTree(node.right);
    }

    private static void swap(TreeNode root) {
        TreeNode left = root.left; // 先记录左孩子
        root.left = root.right; // 左孩子等于右孩子
        root.right = left; // 再将右孩子等于之前记录的左孩子
    }

    /*
        前序遍历迭代
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                swap(curr);
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                curr = pop.right;
            }
        }
        return root;
    }

    /*
        前序遍历-迭代，先向栈中放入右孩子再放入左孩子
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            swap(pop);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return root;
    }

    public TreeNode invertTree4(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
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
}
