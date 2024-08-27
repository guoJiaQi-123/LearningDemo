package com.tyut._07binarytree;

import javax.xml.transform.Result;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/5/13
 * @apiNote 513. 找树左下角的值
 */
public class E21findBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
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
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(root);
        int d = 0;
        while (!queue1.isEmpty()) {
            int size = queue1.size();
            d++;
            if (depth == d) {
                return queue1.poll().val;
            }
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue1.poll();
                if (polled.left != null) {
                    queue1.offer(polled.left);
                }
                if (polled.right != null) {
                    queue1.offer(polled.right);
                }
            }
        }
        return -9;
    }

    public int findBottomLeftValue2(TreeNode root) {
        // 定义一个队列用于层序遍历使用
        Queue<TreeNode> queue = new LinkedList<>();
        // 定义一个栈用于存放每层的最左侧元素
        Stack<TreeNode> stack = new Stack<>();
        queue.offer(root);
        // 层序遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 将每层的最左侧元素加入栈中
            stack.push(queue.peek());
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
        // 返回栈顶元素的值，也就是最后一个入栈的元素，即最后一层的最左侧元素
        return stack.pop().val;
    }


    public int findBottomLeftValue3(TreeNode root) {
        // 定义一个队列用于层序遍历使用
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 层序遍历
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                if (i == 0) {
                    // 记录最后一行的最左侧元素的值
                    result = polled.val;
                }
                if (polled.left != null) {
                    queue.offer(polled.left);
                }
                if (polled.right != null) {
                    queue.offer(polled.right);
                }
            }
        }
        return result;
    }


    // 递归
    private int result = 0; // 记录结果
    private int maxDepth = -1; // 记录最大深度

    public int findBottomLeftValue4(TreeNode root) {
        // 递归方法
        doFindBottomLeftValue4(root, 0);
        return result;
    }

    /**
     *
     * @param root 当前遍历到的节点
     * @param depth 当前节点深度
     */
    private void doFindBottomLeftValue4(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 如果遍历到的节点为叶子节点
        if (root.left == null && root.right == null) {
            // 并且当前节点深度大于最大深度
            if (depth > maxDepth) {
                // 记录最大深度
                maxDepth = depth;
                // 记录当前节点的值
                result = root.val;
            }
        }
        if (root.left != null) {
            // 递归左孩子
            doFindBottomLeftValue4(root.left, depth + 1);
        }
        if (root.right != null) {
            // 递归右孩子
            doFindBottomLeftValue4(root.right, depth + 1);
        }
    }
}
