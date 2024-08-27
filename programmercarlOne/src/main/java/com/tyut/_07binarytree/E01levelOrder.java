package com.tyut._07binarytree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/5/1
 * @apiNote 102. 二叉树的层序遍历
 */
public class E01levelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // 二叉树的层序遍历需要队列数据结构
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        // 将根节点放入队列
        queue.offer(root);
        int t = 1; // 记录每一层节点的个数
        while (!queue.isEmpty()) {
            int t1 = 0; // 记录下一层节点的个数
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                TreeNode polled = queue.poll();
                level.add(polled.val);
                if(polled.left!=null){
                    queue.offer(polled.left);
                    t1++;
                }
                if(polled.right!=null){
                    queue.offer(polled.right);
                    t1++;
                }
            }
            t = t1;
            result.add(level);
        }
        return result;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // 直接使用队列的长度表示每一层节点的个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                level.add(polled.val);
                // 如果有左右孩子，则加入队列
                if(polled.left!=null){
                    queue.offer(polled.left);
                }
                if(polled.right!=null){
                    queue.offer(polled.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
