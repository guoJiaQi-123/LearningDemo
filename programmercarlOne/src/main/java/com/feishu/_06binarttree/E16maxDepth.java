package com.feishu._06binarttree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/8/17
 * @apiNote 559. N 叉树的最大深度
 */
public class E16maxDepth {
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

    /*
        层序遍历 - 定义一个遍历记录最大深度
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0; // 定义一个变量表示最大深度
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDepth++; // 每遍历一层，最大深度++
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (!node.children.isEmpty()) {
                    queue.addAll(node.children);
                }
            }
        }
        return maxDepth;
    }

    /*
        递归法，后序遍历求root节点的高度
     */
    public int maxDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        int childMaxDepth = 0;
        // 求子节点中的最大深度
        for (Node child : root.children) {
            childMaxDepth = Math.max(childMaxDepth, maxDepth2(child));
        }
        // 中间节点的深度需要在最大子节点是深度基础上再加1
        return childMaxDepth + 1;
    }
}
