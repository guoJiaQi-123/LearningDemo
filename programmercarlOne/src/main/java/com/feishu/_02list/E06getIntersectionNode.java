package com.feishu._02list;

import com.tyut._02list.ListNode;

/**
 * @version v1.0
 * @author OldGj 2024/7/26
 * @apiNote 面试题 02.07. 链表相交
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
            // 无论是否有无相交，都会在该循环最后走到A，B两个指针相等
            // 有交点，同时指向相交节点 返回相交节点
            // 无交点，同时指向null节点 返回null
            if (currA == currB) {
                return currA;
            }

            if (currA == null) {
                currA = headB; // 走完A链表走B链表
            } else {
                currA = currA.next;
            }

            if (currB == null) {
                currB = headA; // 走完B链表走A链表
            } else {
                currB = currB.next;
            }
        }
    }
}
