package com.feishu._06binarttree;

import java.util.*;

/**
 * @version v1.0
 * @author OldGj 2024/8/12
 * @apiNote 107. 二叉树的层序遍历 II
 */
public class E05levelOrderBottom {
    /*
        正常的层序遍历，只不过先将每一层遍历到的元素加入栈中
        最后将栈中的元素弹栈再加入结果集中，实现反转
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 结果集
        List<List<Integer>> res = new ArrayList<>();
        // 栈
        Stack<List<Integer>> result = new Stack<>();
        if (root == null) {
            return res;
        }
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
            // 入栈
            result.push(level);
        }
        // 将栈中的元素弹栈加入结果集合
        while (!result.isEmpty()) {
            res.add(result.pop());
        }
        return res;
    }

    /*
        正常的层序遍历，在加入每一层的元素到结果集时，始终加入到结果集的链表头 res.add(0, level);
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
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
            res.add(0, level);
        }
        return res;
    }
}
