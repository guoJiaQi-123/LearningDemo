package com.feishu._02list;

import java.util.Random;

/**
 * @version v1.0
 * @author OldGj 2024/7/27
 * @apiNote 141. 环形链表
 */
public class E07hasCycle {
    /*
        使用虚拟头节点
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p = new ListNode(-1, head); // 哨兵节点
        ListNode slow = p; // 慢指针
        ListNode fast = p; // 快指针
        do {
            slow = slow.next; // 慢指针一次走一步
            fast = fast.next.next;  // 快指针一次走两步
            // 如果快指针指向的节点为null，或者快指针的下一个节点指向为null，说明链表中不存在环
            if (fast == null || fast.next == null) {
                return false;
            }
        } while (slow != fast); // 否则，只要快慢指针不相等，则一直循环
        // 如果快慢指针重合，说明快指针通过环又找到了慢指针，说明链表存在环，返回true
        return true;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
