package com.tyut._02list;

/**
 * @author OldGj 2024/03/19
 * @version v1.0
 * @apiNote 141. 环形链表
 */
public class E08hasCycle {

    /*
        不使用虚拟头节点
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head; // 慢指针
        ListNode fast = head; // 快指针
        // 快指针不为null且下一个节点也不为null，一直循环
        while (fast != null && fast.next != null) {
            slow = slow.next; // 慢指针一次走一步
            fast = fast.next.next; // 慢指针一次走两步
            // 循环过程中，如果快慢指针重合，说明有环
            if (slow == fast) {
                return true;
            }
        }
        // 快指针为null，说明无环
        return false;
    }
}
