package com.tyut._02list;

/**
 * @author OldGj 2024/03/14
 * @version v1.0
 * @apiNote 链表的节点类
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
