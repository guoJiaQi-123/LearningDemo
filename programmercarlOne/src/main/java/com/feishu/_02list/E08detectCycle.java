package com.feishu._02list;

/**
 * @version v1.0
 * @author OldGj 2024/7/27
 * @apiNote 142. 环形链表 II
 */
public class E08detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head; // 慢指针
        ListNode fast = head; // 快指针
        // 只要快指针指向的不为null并且快指针的next指针指向的也不为null，则一直循环
        while (fast != null && fast.next != null) {
            // 慢指针一次走一步
            slow = slow.next;
            // 快指针一次走两步
            fast = fast.next.next;
            // 如果存在环，慢指针与快指针重合
            if (slow == fast) {
                // 此时让慢指针回到head链表头节点
                slow = head;
                // 并且将快指针速度改为一次走一步，快慢指针下次相交的节点就是入环节点
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        // 如果退出循环，说明不存在环
        return null;
    }
}
