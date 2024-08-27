package com.feishu._02list;

/**
 * @version v1.0
 * @author OldGj 2024/7/24
 * @apiNote 203. 移除链表元素
 */
public class E01removeElements {

    /*
        不添加虚拟节点方式，删除头结点需要对头节点额外判断
     */
    public ListNode removeElements(ListNode head, int val) {
        // 如果头结点要删除，则直接移动head指针---> 对删除头结点做额外判断
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode prev = head; // 当前遍历到的节点的前一个节点
        ListNode curr = prev.next; // 当前遍历到的节点
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next; // 删除当前节点就是将当前节点的前一个节点的next指针指向当前节点的下一个节点
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    /*
        使用哨兵节点，统一操作
        即使删除头结点的过程也和删除其他非头结点的过程统一，都是前一个节点的next指针指向待删除节点的next节点
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode s = new ListNode(666, head); // 哨兵节点
        ListNode prev = s; // 前一个节点
        ListNode curr = prev.next; // 遍历到的当前节点
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return s.next;
    }

    /*
        递归法
     */
    public ListNode removeElements3(ListNode head, int val) {
        // 递归的终止条件
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
