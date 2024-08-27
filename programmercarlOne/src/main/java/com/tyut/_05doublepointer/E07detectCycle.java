package com.tyut._05doublepointer;

import com.tyut._02list.ListNode;

/**
 * @version v1.0
 * @author OldGj 2024/04/06
 * @apiNote 142. 环形链表 II
 */
public class E07detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head; // 乌龟
        ListNode fast = head; // 兔子
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next; // 乌龟每次走一步
            fast = fast.next.next; // 兔子每次走两步
            if (fast == slow) {
                // 如果遇到环的入口<乌龟和兔子相遇>
                // 此时让乌龟回到启动，兔子一次走一步，再次相遇时的地点就是入环点
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
    }

    public ListNode detectCycle2(ListNode head) {
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
