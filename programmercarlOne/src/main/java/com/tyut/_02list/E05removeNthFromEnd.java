package com.tyut._02list;

/**
 * @author OldGj 2024/03/18
 * @version v1.0
 * @apiNote 19. 删除链表的倒数第 N 个结点
 */
public class E05removeNthFromEnd {
    /*
        fast先走n步以后，再和慢指针同时走，直到fast指针走到链表最后的null处，此时slow对应的就是待删除的节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 哨兵节点
        ListNode s = new ListNode(-1, head);
        ListNode fast = s.next; // 快指针
        ListNode slow = s.next; // 慢指针
        ListNode prev = s;
        // fast先走n步，需要额外定义一个prev指针指向待删除节点的上一个节点
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            // 每次移动slow节点，先记录下来当前slow再移动，此时的prev就是slow节点的前一个节点
            prev = slow;
            slow = slow.next;
        }
        // 将slow节点删除
        prev.next = slow.next;
        return s.next;
    }

    /*
            fast先走n+1步以后，再和慢指针同时走，直到fast指针走到链表最后的null处，此时slow对应的就是待删除节点的上一个节点
    */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 哨兵节点
        ListNode s = new ListNode(-1, head);
        ListNode fast = s;
        ListNode slow = s;
        // fast先走n+1步，不需要额外定义一个prev指针指向待删除节点的上一个节点
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 将slow指针指向的下一个节点从链表中删除
        slow.next = slow.next.next;
        return s.next;
    }
}
