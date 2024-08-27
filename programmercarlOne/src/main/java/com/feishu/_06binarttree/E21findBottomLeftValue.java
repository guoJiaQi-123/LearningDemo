package com.feishu._06binarttree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/8/18
 * @apiNote 513. 找树左下角的值
 */
public class E21findBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = getDepth(root); // 获取当前树的高度
        int depthNow = 0;
        while (!queue.isEmpty()) {
            depthNow++; // 每遍历一层，将当前高度++
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 如果当前高度等于了数的总高，说明遍历到了最后一层，直接返回队列第一个元素的值
                if (depthNow == depth) {
                    return node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return 0;
    }

    // 获取当前树高
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left); // 左子树高
        int right = getDepth(root.right); // 右子树高
        return Math.max(left, right) + 1; // 树的总高度
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
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
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
                TreeNode node = queue.poll();
                if (i == 0) {
                    // 记录每一行的最左侧元素的值，每遍历一行，将前面的覆盖，最后留下的就是最后一行的
                    result = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    int maxDepth = -1; // 最大深度
    int result = 0; // 结果

    public int findBottomLeftValue4(TreeNode root) {
        doFindBottomLeftValue(root, 0);
        return result;
    }

    // 递归函数
    private void doFindBottomLeftValue(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        // 如果当前遍历的节点深度大于原先的最大深度
        if (depth > maxDepth) {
            maxDepth = depth; // 更新最大深度
            result = node.val; // 更新结果变量为更深的靠左节点的值
        }
        // 递归左子树
        if (node.left != null) {
            doFindBottomLeftValue(node.left, depth + 1);
        }
        // 递归右子树
        if (node.right != null) {
            doFindBottomLeftValue(node.right, depth + 1);
        }
    }
}
