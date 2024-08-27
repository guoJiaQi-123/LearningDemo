package com.tyut._07binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/5/2
 * @apiNote 117. 填充每个节点的下一个右侧节点指针 II
 */
public class E08connect2 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // 层序遍历需要的队列数据结构
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node polled = queue.poll();
                // 如果i == size - 1 说明当前遍历到了每一层的最后一个节点，将该节点的next指针置为null
                if (i == size - 1) {
                    polled.next = null;
                } else {//否则，将当前节点的next指针指向队列头节点（当前节点的右侧节点）
                    polled.next = queue.peek();
                }
                // 层序遍历代码，将当前节点的子节点加入队列
                if (polled.left != null) {
                    queue.offer(polled.left);
                }
                if (polled.right != null) {
                    queue.offer(polled.right);
                }
            }
        }
        return root;
    }
}
