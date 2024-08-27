package com.tyut._02list;

/**
 * @author OldGj 2024/03/17
 * @version v1.0
 * @apiNote 24. 两两交换链表中的节点
 */
public class E04swapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = new ListNode(-1,head); // 哨兵节点
        ListNode curr = p;
        ListNode next; // 临时节点，用于存放两个节点后的那个节点
        ListNode firstNode; // 临时节点，用于存放两个节点的第一个节点
        ListNode secondNode; // 临时节点，用于存放两个节点的第二个节点
        while (curr.next != null && curr.next.next != null) {
            // 初始化节点
            next = curr.next.next.next;
            firstNode = curr.next;
            secondNode = curr.next.next;
            // 模拟赋值
            curr.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = next;
            curr = firstNode; // 1->2->3->4  中的firstNode为1
                              // 2->1->3->4  时curr 指向了1，因此下次循环交换的是3和4的位置
        }
        return p.next;
    }

    public static void main(String[] args) {
        E04swapPairs e04swapPairs = new E04swapPairs();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode listNode = e04swapPairs.swapPairs(head);
        System.out.println(listNode);
    }
}
