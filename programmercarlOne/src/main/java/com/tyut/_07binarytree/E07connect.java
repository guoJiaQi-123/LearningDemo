package com.tyut._07binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/5/2
 * @apiNote 116. 填充每个节点的下一个右侧节点指针
 */
public class E07connect {
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

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node leftMost = root;
        while (leftMost.left != null) {
            Node head = leftMost;
            while (head != null) {
                // 将head的左孩子的next指针指向head的右孩子
                head.left.next = head.right;
                // 将head的右孩子的next指针指向head的next的左孩子（如果head的next存在）
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // 指针向后移动
                head = head.next;
            }
            // 去下一层的最左的节点
            leftMost = leftMost.left;
        }
        return root;
    }
}
