package com.tyut._05doublepointer;

import com.tyut._02list.ListNode;

/**
 * @version v1.0
 * @apiNote 面试题 02.07. 链表相交
 * @author OldGj 2024/04/06
 */
public class E06getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode m = headA;
        ListNode n = headB;
        // 如果没有相交，返回null值时也是m和n两个链表同时到null
        // 想要走到相交节点，链表m和链表n走的步数都是一样的
        while (true) {
            if (m == n) {
                return m;
            }
            if (m == null) {
                m = headB;
            } else {
                m = m.next;
            }

            if (n == null) {
                n = headA;
            } else {
                n = n.next;
            }
        }
    }


}
