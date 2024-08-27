package com.tyut._02list;

/**
 * @author OldGj 2024/03/14
 * @version v1.0
 * @apiNote 203. 移除链表元素
 */
public class E01removeElements {

    // 不添加虚拟节点方式，需要对头节点额外判断
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    // 添加哨兵节点
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 哨兵节点
        ListNode s = new ListNode(666, head);
        ListNode prev = s; // 前继节点
        ListNode curr = prev.next; // 当前节点
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return s.next;
    }

    // 递归法
    public ListNode removeElements3(ListNode head, int val) {
        //如果头节点为空，则返回空
        if (head == null) {
            return null;
        }
        //如果头节点的值等于val，则返回移除头节点之后的链表
        if (head.val == val) {
            return removeElements3(head.next, val);
        } else {//否则，将头节点的下一个节点作为头节点，并递归调用removeElements函数，返回值作为当前节点的next节点
            head.next = removeElements3(head.next, val);
            return head;
        }
    }
}
