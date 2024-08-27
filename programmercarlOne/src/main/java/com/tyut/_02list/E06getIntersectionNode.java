package com.tyut._02list;

/**
 * @author OldGj 2024/03/19
 * @version v1.0
 * @apiNote 160. 相交链表
 */
public class E06getIntersectionNode {
    /*
        A链表走完走B链表，B链表走完走A链表，如果有相交在循环一次以后一定会同时到达相交节点
        如果没有相交会走完A和B链表同时到达NULL
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        while (true) {
            if (currA == currB) {
                return currA;
            }
            if (currA == null) {
                currA = headB;
            } else {
                currA = currA.next;
            }

            if (currB == null) {
                currB = headA;
            } else {
                currB = currB.next;
            }
        }
    }
}
