package com.feishu._06binarttree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/8/20
 * @apiNote 617. 合并二叉树
 */
public class E26mergeTrees {

    /*
        递归，前序遍历
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2; // root1为null，返回root2即可，即使root2为null也无所谓
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val; // 将新树的节点直接赋值到原来的root1树上即可
        // root1 的左子树是：合并 root1左子树 root2左子树之后的左子树。
        root1.left = mergeTrees(root1.left, root2.left);
        // root1 的右子树是：合并 root1右子树 root2右子树之后的右子树。
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /*
        使用栈迭代
     */
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // 使用栈进行迭代
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root2);
        stack.push(root1);
        while (!stack.isEmpty()) {
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            // 此时两个节点一定不为空，val相加
            node1.val += node2.val;
            // 两个节点都不为null，则全部入队
            if (node2.right != null && node1.right != null) {
                stack.push(node2.right);
                stack.push(node1.right);
            } else {
                // 如果node1为null，node2不为null，则将node2的值赋值给node1，此时的node1是root1
                if (node1.right == null) {
                    node1.right = node2.right;
                }
            }
            // 同理
            if (node2.left != null && node1.left != null) {
                stack.push(node2.left);
                stack.push(node1.left);
            } else {
                if (node1.left == null) {
                    node1.left = node2.left;
                }
            }
        }
        return root1;
    }

    /*
        使用队列迭代
     */
    public TreeNode mergeTrees3(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            // 此时两个节点一定不为空，val相加
            node1.val = node1.val + node2.val;
            // 如果两棵树左节点都不为空，加入队列
            if (node1.left != null && node2.left != null) {
                queue.offer(node1.left);
                queue.offer(node2.left);
            }
            // 如果两棵树右节点都不为空，加入队列
            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
            // 若node1的左节点为空，直接赋值
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            // 若node1的右节点为空，直接赋值
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }
}
