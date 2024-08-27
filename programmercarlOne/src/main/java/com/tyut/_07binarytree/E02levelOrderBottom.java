package com.tyut._07binarytree;

import java.util.*;

/**
 * @version v1.0
 * @author OldGj 2024/5/1
 * @apiNote 107. 二叉树的层序遍历 II
 */
public class E02levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // 栈数据结构暂存数据
        Stack<List<Integer>> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        // 正常的层序遍历，并将结果放入栈数据结构
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                level.add(polled.val);
                if (polled.left != null) {
                    queue.offer(polled.left);
                }
                if (polled.right != null) {
                    queue.offer(polled.right);
                }
            }
            stack.push(level);
        }
        // 将栈中的数据弹出加入结果集合，实现顺序反转
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
