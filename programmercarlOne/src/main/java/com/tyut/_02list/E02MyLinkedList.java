package com.tyut._02list;

/**
 * @author OldGj 2024/03/14
 * @version v1.0
 * @apiNote 707. 设计链表
 */
public class E02MyLinkedList {

    // 链表节点类
    static class ListNode {
        int val;
        int index;
        ListNode prev; // 双向链表
        ListNode next;

        public ListNode(int val, int index) {
            this.val = val;
            this.index = index;
        }

        public ListNode(int val, int index, ListNode prev, ListNode next) {
            this.val = val;
            this.index = index;
            this.prev = prev;
            this.next = next;
        }

        public ListNode() {
        }
    }


    static class MyLinkedList {
        // 头尾哨兵节点
        ListNode head;
        ListNode tail;

        public MyLinkedList() {
            head = new ListNode(-1,-1);
            tail = new ListNode(-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index == 0) {
                return head.next.val;
            }
            ListNode curr = head.next;
            while (curr != null && curr.index != index) {
                curr = curr.next;
            }

            if (curr == null) {//没找到
                return -1;
            } else { // 找到
                return curr.val;
            }
        }

        public void addAtHead(int val) {
            ListNode oldHead = head.next;
            ListNode newHead = new ListNode(val, 0, head, oldHead);
            head.next = newHead;
            oldHead.prev = newHead;
            ListNode curr = oldHead;
            while (curr != tail) {
                curr.index++; // 头部添加一个节点，后序节点的index都需要更新
                curr = curr.next;
            }
        }

        public void addAtTail(int val) {
            ListNode oldTail = tail.prev;
            ListNode newTail = new ListNode(val, oldTail.index + 1, oldTail, tail);
            oldTail.next = newTail;
            tail.prev = newTail;
        }

        public void addAtIndex(int index, int val) {
            ListNode curr = head.next;
            while (index != 0 && curr != null && curr.index != index - 1) {
                curr = curr.next;
            }
            if (index == 0) {
                addAtHead(val);
                return;
            }
            if (curr == null) { // 没找到
                return;
            } else {
                ListNode oldNode = curr.next;
                ListNode addNode = new ListNode(val, index, curr, oldNode);
                curr.next = addNode;
                oldNode.prev = addNode;
                ListNode c = oldNode;
                while (c != tail) {
                    c.index++;
                    c = c.next;
                }
            }
        }

        public void deleteAtIndex(int index) {
            ListNode curr = head.next;
            while (index != 0 && curr != null && curr.index != index - 1) {
                curr = curr.next;
            }

            if (index == 0) {
                head.next = curr.next;
                return;
            }
            if (curr == null) { // 没找到
                return;
            } else { //找到
                if (curr.next == tail) {
                    return;
                }
                ListNode deleted = curr.next;
                curr.next = deleted.next;
                deleted.next.prev = curr;
                ListNode c = deleted.next;
                while (c != tail) {
                    c.index--; // 删除一个节点，后序节点的index全部需要-1
                    c = c.next;
                }
            }
        }
    }
}
