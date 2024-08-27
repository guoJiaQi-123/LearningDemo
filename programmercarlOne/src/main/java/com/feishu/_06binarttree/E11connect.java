package com.feishu._06binarttree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/8/14
 * @apiNote 117. 填充每个节点的下一个右侧节点指针 II
 */
public class E11connect {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

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

    // 层序遍历，在层序遍历的最后一个节点next指向null，其余节点next指向下一个节点（下一个节点存在队列中）
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
                Node node = queue.poll();
                // 如果i == size - 1 说明当前遍历到了每一层的最后一个节点，将该节点的next指针置为null
                if (i == size - 1) {
                    node.next = null;
                } else {//否则，将当前节点的next指针指向队列头节点（当前节点的右侧节点）
                    node.next = queue.peek();
                }
                // 层序遍历代码，将当前节点的子节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    Node last = null, nextStart = null;

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }
}
