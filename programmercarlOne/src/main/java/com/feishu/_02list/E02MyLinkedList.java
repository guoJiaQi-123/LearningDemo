package com.feishu._02list;

import com.tyut._07binarytree.TreeNode;

/**
 * @version v1.0
 * @author OldGj 2024/7/24
 * @apiNote 707. 设计链表
 */
public class E02MyLinkedList {


    static class MyLinkedList {
        static class ListNode {
            int val;
            int index;
            ListNode prev;
            ListNode next;

            public ListNode(int val, int index, ListNode prev, ListNode next) {
                this.val = val;
                this.index = index;
                this.prev = prev;
                this.next = next;
            }

            public ListNode(int val, int index) {
                this.val = val;
                this.index = index;
            }
        }

        ListNode head; // 虚拟头节点
        ListNode tail; // 虚拟尾节点

        public MyLinkedList() {
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        /**
         * 返回index索引处节点的值
         */
        public int get(int index) {
            if (index == 0) {
                return head.next.val; // index为0，返回头结点的值
            }
            ListNode curr = head.next;
            // 在链表中查找index索引处的节点
            while (curr != null && curr.index != index) {
                curr = curr.next;
            }
            if (curr == null) {//没找到
                return -1;
            } else { // 找到
                return curr.val;
            }
        }

        public void addAtHead(int val) {
            ListNode oldHead = head.next; // 旧的链表头节点
            ListNode newHead = new ListNode(val, 0, head, oldHead);
            head.next = newHead; // 虚拟节点的next指向新的链表头节点
            oldHead.prev = newHead; // 旧的链表头节点的prev指向新的链表头节点
            // 链表头部添加了一个节点，后序链表中的节点index索引需要全部++
            ListNode curr = oldHead;
            while (curr != tail) {
                curr.index++;
                curr = curr.next;
            }
        }

        public void addAtTail(int val) {
            ListNode oldTail = tail.prev; // 旧的链表尾节点
            ListNode newTail = new ListNode(val, oldTail.index + 1, oldTail, tail);
            // 旧的链表尾节点的next指向新的链表尾节点
            oldTail.next = newTail;
            // 虚拟节点的prev指向新的链表尾节点
            tail.prev = newTail;
        }

        public void addAtIndex(int index, int val) {
            ListNode curr = head.next;
            // 在链表中查找index-1索引的节点
            while (index != 0 && curr != null && curr.index != index - 1) {
                curr = curr.next;
            }
            // 如果index为0，相当于在链表头部插入节点
            if (index == 0) {
                addAtHead(val);
                return;
            }
            if (curr == null) { // 没找到
                return;
            } else {
                ListNode oldNode = curr.next;
                ListNode addNode = new ListNode(val, index, curr, oldNode);
                curr.next = addNode;
                oldNode.prev = addNode;
                ListNode c = oldNode;
                while (c != tail) {
                    c.index++;
                    c = c.next;
                }
            }
        }

        public void deleteAtIndex(int index) {
            ListNode curr = head.next;
            // 在链表中查找index-1索引的节点
            while (index != 0 && curr != null && curr.index != index - 1) {
                curr = curr.next;
            }
            // 如果index为0，相当于删除头节点，此时只需要将虚拟头结点的next指针向后移动一位
            if (index == 0) {
                head.next = curr.next;
                return;
            }
            if (curr == null) { // 没找到
                return;
            } else { //找到
                if (curr.next == tail) {
                    return;
                }
                ListNode deleted = curr.next;
                curr.next = deleted.next;
                deleted.next.prev = curr;
                ListNode c = deleted.next;
                while (c != tail) {
                    c.index--; // 删除一个节点，后序节点的index全部需要-1
                    c = c.next;
                }
            }
        }
    }

    //单链表
    static class MyLinkedList2 {
        //单链表
        static class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }
        }

        //size存储链表元素的个数
        int size;
        //虚拟头结点
        ListNode head;

        //初始化链表
        public MyLinkedList2() {
            size = 0;
            head = new ListNode(0);
        }

        //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
        public int get(int index) {
            //如果index非法，返回-1
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode currentNode = head;
            //包含一个虚拟头节点，所以查找第 index+1 个节点
            for (int i = 0; i <= index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.val;
        }

        //在链表最前面插入一个节点，等价于在第0个元素前添加
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        //在链表的最后插入一个节点，等价于在(末尾+1)个元素前添加
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
        // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
        // 如果 index 大于链表的长度，则返回空
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            size++;
            //找到要插入节点的前驱
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            ListNode toAdd = new ListNode(val);
            toAdd.next = pred.next;
            pred.next = toAdd;
        }

        //删除第index个节点
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            if (index == 0) {
                head = head.next;
                return;
            }
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            pred.next = pred.next.next;
        }
    }

    //双链表
    static class MyLinkedList3 {
        static //双链表
        class ListNode {
            int val;
            ListNode next, prev;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }
        }

        //记录链表中元素的数量
        int size;
        //记录链表的虚拟头结点和尾结点
        ListNode head, tail;

        public MyLinkedList3() {
            //初始化操作
            this.size = 0;
            this.head = new ListNode(0);
            this.tail = new ListNode(0);
            //这一步非常关键，否则在加入头结点的操作中会出现null.next的错误！！！
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            //判断index是否有效
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = this.head;
            //判断是哪一边遍历时间更短
            if (index >= size / 2) {
                //tail开始
                cur = tail;
                for (int i = 0; i < size - index; i++) {
                    cur = cur.prev;
                }
            } else {
                for (int i = 0; i <= index; i++) {
                    cur = cur.next;
                }
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            //等价于在第0个元素前添加
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            //等价于在最后一个元素(null)前添加
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            //index大于链表长度
            if (index > size) {
                return;
            }
            //index小于0
            if (index < 0) {
                index = 0;
            }
            size++;
            //找到前驱
            ListNode pre = this.head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            //新建结点
            ListNode newNode = new ListNode(val);
            newNode.next = pre.next;
            pre.next.prev = newNode;
            newNode.prev = pre;
            pre.next = newNode;

        }

        public void deleteAtIndex(int index) {
            //判断索引是否有效
            if (index < 0 || index >= size) {
                return;
            }
            //删除操作
            size--;
            ListNode pre = this.head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next.next.prev = pre;
            pre.next = pre.next.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList5 myLinkedList5 = new MyLinkedList5();
        myLinkedList5.addAtHead(1);
        myLinkedList5.addAtTail(3);
        myLinkedList5.addAtIndex(1, 2);
        myLinkedList5.get(1);
    }

    static class MyLinkedList5 {

        static class ListNode {
            int val;
            ListNode next;
            ListNode pre;

            public ListNode(int val) {
                this.val = val;
            }
        }

        int size;
        ListNode head, tail;

        // 构造方法，初始化链表，定义长度，头节点，尾节点
        public MyLinkedList5() {
            size = 0;
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            return getNode(index).val;
        }

        public ListNode getNode(int index) {
            ListNode curr;
            // 判断更短路径
            if (index >= size / 2) {
                // tail开始
                curr = tail;
                for (int i = 0; i < size - index; i++) {
                    curr = curr.pre;
                }
            } else {
                curr = head;
                for (int i = 0; i <= index; i++) {
                    curr = curr.next;
                }
            }
            return curr;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            ListNode addNode = new ListNode(val);
            ListNode pred = head;
            if (index <= 0) {
                index = 0;
            }
            if (index == size) {
                // 获得最后一个节点
                pred = getNode(index - 1);
            } else {
                pred = getNode(index).pre;
            }
            size++;
            addNode.next = pred.next;
            pred.next.pre = addNode;
            addNode.pre = pred;
            pred.next = addNode;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            // 找到index的前驱
            ListNode curr = getNode(index);
            curr.next.pre = curr.pre;
            curr.pre.next = curr.next;
            size--;
        }

    }

}
