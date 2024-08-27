package com.tyut._02list;

/**
 * @author OldGj 2024/03/19
 * @version v1.0
 * @apiNote 142. 环形链表 II
 */
public class E07detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head; // 乌龟
        ListNode fast = head; // 兔子
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
