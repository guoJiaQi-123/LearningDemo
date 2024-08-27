package com.tyut._02list;


import java.util.LinkedList;

/**
 * @author OldGj 2024/03/15
 * @version v1.0
 * @apiNote 206. 反转链表
 */
public class E03reverseList {

    // 反转链表 每次创建新的节点插入到链表头实现反转 浪费空间
    public ListNode reverseList(ListNode head) {
        ListNode n1 = null; // 新链表头结点
        ListNode o1 = head; // 旧链表头结点
        while (o1 != null) {
            n1 = new ListNode(o1.val, n1);
            o1 = o1.next;
        }
        return n1;
    }

    // 面向对象方式
    public ListNode reverseList2(ListNode head) {
        //创建一个链表，将head的值赋值给链表
        List oldList = new List(head); // 旧链表
        //创建一个新的链表，初始头节点为null
        List newList = new List(null); // 新链表
        //当链表头节点不为空时，循环
        while (oldList.head != null) {
            //将链表头节点删除，并赋值给headNode
            ListNode headNode = oldList.removeHead();
            //将headList添加到新链表的头部
            newList.addHead(headNode);
        }
        return newList.head;
    }

    static class List {
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        /**
         * 删除链表头节点
         *
         * @return 删除的链表头节点
         */
        public ListNode removeHead() {
            //将链表头节点赋值给head_old
            ListNode head_old = head;
            if (head_old != null) {
                head = head_old.next;
            }
            //返回删除的节点
            return head_old;
        }

        /**
         * 向链表头部添加节点
         *
         * @param node 待添加节点
         */
        public void addHead(ListNode node) {
            //将添加的节点指向链表头节点
            node.next = head;
            //将添加的节点赋值给链表头节点
            head = node;
        }
    }

    // 双指针 直接在原链表上实现反转
    public ListNode reverseList3(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            // 记录
            ListNode next = curr.next;
            // 反转
            curr.next = pre;
            // 归位
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 使用栈解决反转链表的问题
    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 创建一个栈
        LinkedList<ListNode> stack = new LinkedList<>();
        // 所有节点入栈
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        // 反转链表的哨兵节点
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            cur.next = pop;
            cur = cur.next;
        }
        // 采用这种方法需要注意一点。就是当整个出栈循环结束以后，cur正好指向原来链表的第一个结点
        // 而此时结点1中的next指向的是结点2，因此最后还需要cur.next = null
        cur.next = null;
        return newHead.next;
    }
}
