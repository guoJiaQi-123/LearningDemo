package com.tyut._05doublepointer;

import com.tyut._02list.ListNode;

import java.util.Stack;

/**
 * @author OldGj 2024/04/01
 * @version v1.0
 * @apiNote 206. 反转链表
 */
public class E04reverseList {


    /*
        双指针
     */
    public ListNode reverseList(ListNode head) {
        // 反转后末尾的null
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 记录当前节点的下一个节点
            ListNode next = curr.next;
            // 指向前一个节点《反转的关键》
            curr.next = prev;
            // 移动到下一个指针
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /*
        使用栈实现反转链表
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();
        // 所有节点入栈
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        // 反转后链表的哨兵节点
        ListNode s = new ListNode(-1);
        ListNode c = s;
        while (!stack.isEmpty()) {
            c.next = stack.pop();
            c = c.next;
        }
        // 使用栈这种方法，当栈为null时，退出循环，此时c指针指向原来的链表头节点
        // 而此时链表头节点的next指针还指向原来的链表第二个节点，所以需要将c指针的next指针置null
        c.next = null;
        return s.next;
    }

    /*
     递归
     */
    public ListNode reverseList3(ListNode head) {
        // 递归结束条件
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        // 递归结束，返回原先链表的最后一个节点也就是反转链表的头节点
        ListNode last = reverseList3(head.next);
        /*
            1-2-3-4-5

            5-4     => head.next.next = head;   head = 4, head.next = 5, head.next.next = 5.next
            4-null   =》 head.next = null;
            --------------
            4-3
            3-null
            --------------
         */
        head.next.next = head;
        head.next = null;
        return last;
    }
}
