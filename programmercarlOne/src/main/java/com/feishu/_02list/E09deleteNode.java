package com.feishu._02list;

import com.tyut._02list.ListNode;

/**
 * @author OldGj 2024/7/27
 * @version v1.0
 * @apiNote 237. 删除链表中的节点
 */
public class E09deleteNode {
    /*
       如果删除一个节点，则必须知道这个节点的前一个节点，参数给出的是待删除节点本身，无法得知其上一个节点
       因此想要实现删除节点值，只能使用逻辑删除，将待删除节点的下一个节点值赋值到待删除节点，然后删除待删除节点的下一个节点
       通过这种方式，在逻辑上从链表中将待删除节点的值移除在链表中
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
