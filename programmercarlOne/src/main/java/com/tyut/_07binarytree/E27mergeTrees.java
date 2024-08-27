package com.tyut._07binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/6/5
 * @apiNote 617. 合并二叉树
 */
public class E27mergeTrees {
    // 方法一：自己的思路，使用模拟了，代码的阅读性不高
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = null;
        // 两节点都不为null
        if (root1 != null && root2 != null) {
            // 新节点的值为两节点之和
            root = new TreeNode(root1.val + root2.val);
        } else if (root1 == null && root2 != null) { // root1为null而root2不为null
            // 新节点的值为root2的值，但是为了递归不报空指针，需要为root1创建一个节点对象，赋值为0即可
            // 通过这种方式，递归会继续向下执行，遍历到root2后序任然可能存在的节点
            root1 = new TreeNode(0);
            root = new TreeNode(root2.val);
        } else if (root1 != null && root2 == null) {
            // 这种同理
            root2 = new TreeNode(0);
            root = new TreeNode(root1.val);
        }
        // 递归构造根节点的左子树
        root.left = mergeTrees(root1.left, root2.left);
        // 递归构造根节点的右子树
        root.right = mergeTrees(root1.right, root2.right);
        // 返回根节点
        return root;
    }

    // 方法二：递归
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        // 如果root1为null,返回root2
        if (root1 == null) return root2;
        // 如果root2为null，返回root1
        if (root2 == null) return root1;
        // 执行到这里说明root1和root2都不为null，将root1.val的值更新
        root1.val += root2.val;
        // 递归构建左右子树
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }

    // 方法三：使用队列迭代
    public TreeNode mergeTrees3(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 ==null) return root1;
        // 层序遍历
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

    // 方法四：使用栈迭代
    public TreeNode mergeTrees4(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root2);
        stack.push(root1);
        while (!stack.isEmpty()) {
            // 此时两个节点一定不为空，val相加
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            node1.val += node2.val;
            // 如果两棵树右节点都不为空，加入栈
            if (node2.right != null && node1.right != null) {
                stack.push(node2.right);
                stack.push(node1.right);
            } else {
                // 若node1的右节点为空，直接赋值
                if (node1.right == null) {
                    node1.right = node2.right;
                }
            }
            // 如果两棵树左节点都不为空，加入队列
            if (node2.left != null && node1.left != null) {
                stack.push(node2.left);
                stack.push(node1.left);
            } else {
                // 若node1的左节点为空，直接赋值
                if (node1.left == null) {
                    node1.left = node2.left;
                }
            }
        }
        return root1;
    }
}
