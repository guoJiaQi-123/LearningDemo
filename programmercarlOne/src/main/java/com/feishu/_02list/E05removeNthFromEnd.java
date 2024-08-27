package com.feishu._02list;

/**
 * @version v1.0
 * @author OldGj 2024/7/25
 * @apiNote 19. 删除链表的倒数第 N 个结点
 */
public class E05removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = new ListNode(-1, head); // 哨兵节点
        ListNode slow = p; // 慢指针
        ListNode fast = p; // 快指针
        for (int i = 0; i < n + 1; i++) { // 快指针先走n+1步
            fast = fast.next;
        }
        while (fast != null) { // 快慢指针一起走，直到快指针指向链表尾部的null
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next; // 删除慢指针指向的下一个节点
        return p.next;
    }
}
