package com.feishu._02list;

/**
 * @version v1.0
 * @author OldGj 2024/7/24
 * @apiNote 206. 反转链表
 */
public class E03reverseList {

    // 头插法 浪费空间
    public ListNode reverseList3(ListNode head) {
        ListNode o1 = head; // 旧链表的头节点
        ListNode n1 = null; // 新链表的头节点
        while (o1 != null) {
            n1 = new ListNode(o1.val, n1); //每次使新链表的值为旧链表中节点的值，但是插入到新链表头
            o1 = o1.next;
        }
        return n1;
    }

    // 双指针
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next; // 保存下一个节点
            curr.next = prev; // 反转链表，当前节点的next指向前一个节点
            prev = curr; // 移动prev指针
            curr = temp; // curr移动到之前保存的下一个节点
        }
        return prev;
    }

    // 递归
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    /**
     * 反转两个节点
     * @param prev 前一个节点
     * @param cur 当前节点
     * @return
     */
    private ListNode reverse(ListNode prev, ListNode cur) {
        // 递归的终止条件
        if (cur == null) {
            return prev;
        }
        ListNode temp = cur.next;// 先保存下一个节点
        cur.next = prev;// 反转
        return reverse(cur, temp); // 当前节点作为下个节点的prev节点，之前记录的temp作为下一个要遍历的节点
    }
}
