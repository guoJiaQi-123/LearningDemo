package com.tyut._05doublepointer;

import com.tyut._02list.ListNode;

/**
 * @version v1.0
 * @author OldGj 2024/04/06
 * @apiNote 19. 删除链表的倒数第 N 个结点
 */
public class E05removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode s = new ListNode(-1, head);
        ListNode slow = s;
        ListNode fast = s;
        // fast先走n+1步，不需要额外定义一个prev指针指向待删除节点的上一个节点
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return s.next;
    }
}
