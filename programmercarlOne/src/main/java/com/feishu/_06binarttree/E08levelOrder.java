package com.feishu._06binarttree;

import java.util.*;

/**
 * @version v1.0
 * @author OldGj 2024/8/14
 * @apiNote 429. N 叉树的层序遍历
 */
public class E08levelOrder {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        // 结果集合
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 层序遍历需要使用的队列数据结构
        Queue<Node> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 使用队列的长度表示为每一层节点个数
            // 因为每一此循环，都需要将队列中的元素全部弹出，并将原队列中节点的子节点（下一层节点）全部入队
            // 因此，每一层遍历队列中的元素个数就是各个层中节点的个数
            int size = queue.size();
            // 定义一个集合用来存储每一层的节点
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                // 如果当前节点有子节点，则全部入队
                if (!node.children.isEmpty()) {
                    queue.addAll(node.children);
                }
            }
            // 每一层的节点加入最终结果集合
            res.add(level);
        }
        return res;
    }
}
