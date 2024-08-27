package com.tyut._07binarytree;

import java.util.*;

/**
 * @version v1.0
 * @author OldGj 2024/5/4
 * @apiNote 222. 完全二叉树的节点个数
 */
public class E15countNodes {


    public int countNodes8(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = countNodes8(root.left); // 左
        int j = countNodes8(root.right); // 右
        return i + j + 1;
    }

    // 前序遍历 递归
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 将遍历到的节点全部加入结果集合
        List<TreeNode> res = new ArrayList<>();
        doCountNodes(root, res);
        return res.size();
    }

    private void doCountNodes(TreeNode node, List<TreeNode> res) {
        if (node == null) {
            return;
        }
        res.add(node);
        doCountNodes(node.left, res);
        doCountNodes(node.right, res);
    }

    // 深度优先搜索 前序遍历 迭代实现
    public int countNodes3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> res = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode popped = stack.pop();
            res.add(popped);
            if (popped.right != null) {
                stack.push(popped.right);
            }
            if (popped.left != null) {
                stack.push(popped.left);
            }
        }
        return res.size();
    }

    // 深度优先搜索 前序遍历 迭代实现
    public int countNodes4(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                res.add(curr);
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode pop = stack.pop();
                curr = pop.right;
            }
        }
        return res.size();
    }

    // 广度优先搜索
    public int countNodes2(TreeNode root) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                res++;
                TreeNode left = polled.left;
                TreeNode right = polled.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
        }
        return res;
    }

    // 利用完全二叉树的性质
    // 情况一：满二叉树 节点数 = 2 ^ 深度 - 1
    // 情况二：分别递归左孩子，和右孩子，递归到某一深度一定会有左孩子或者右孩子为满二叉树，然后依然可以按照情况1来计算。
    public int countNodes5(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0; // 左视图深度
        int rightDepth = 0; // 右视图深度
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        // 如果左视图深度等于右视图深度，说明是一颗满二叉树
        if (leftDepth == rightDepth) {
            // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
            return (2 << leftDepth) - 1;
        }
        return countNodes5(root.left) + countNodes5(root.right) + 1;
    }
}
