package com.feishu._02list;

/**
 * @version v1.0
 * @author OldGj 2024/7/24
 * @apiNote 24. 两两交换链表中的节点
 */
public class E04swapPairs {
    /*
        模拟迭代【画图理解】
     */
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

    /*
        递归
     */
    public ListNode swapPairs2(ListNode head) {
        // base case 退出提交
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归 交换当前节点的下一个节点的后面两个节点并且返回交换后的第一个节点
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }
}
