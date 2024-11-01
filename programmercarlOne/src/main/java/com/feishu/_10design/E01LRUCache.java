package com.feishu._10design;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/11/1
 * @apiNote 146. LRU 缓存
 */
public class E01LRUCache {
    static class LRUCache {

        DoubleLinkedList doubleLinkedList; // 双向链表
        Map<Integer, Node> map; // 哈希表
        int capacity; // 容量

        public LRUCache(int capacity) {
            this.doubleLinkedList = new DoubleLinkedList();
            this.map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            // 如果存在，返回value，并在链表中将当前节点加入链表头部
            if (map.containsKey(key)) {
                Node node = map.get(key);
                doubleLinkedList.remove(node);
                doubleLinkedList.addHead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            // 如果存在，则更新当前key的value并在链表中将当前节点加入链表头部
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                doubleLinkedList.remove(node);
                doubleLinkedList.addHead(node);
            } else {
                // 如果不存在，则新增节点，并进行容量判断
                Node addNode = new Node(key, value);
                map.put(key, addNode);
                doubleLinkedList.addHead(addNode);
                if (map.size() > capacity) {
                    // 如果超出容量，则删除链表尾部节点及其在哈希表中的value
                    Node node = doubleLinkedList.removeLast();
                    map.remove(node.key);
                }
            }
        }

        /**
         * 双向链表的节点类
         */
        static class Node {
            Node prev;
            Node next;
            int key;
            int value;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        /**
         * 双向链表类
         * 该链表头节点表示最近刚被访问过的节点，链表尾节点表示最久没被访问过的节点
         * 每次访问的值都需要将其重新加入到链表头，如果新增数据，则需要判断是否超出容量，如果超出，则需要删除链表尾部的节点（表示最近最少使用）
         */
        static class DoubleLinkedList {
            Node head = new Node();
            Node tail = new Node();

            public DoubleLinkedList() {
                head.next = tail;
                tail.prev = head;
            }

            /**
             *  向链表头加入节点
             * @param newHead
             */
            public void addHead(Node newHead) {
                Node oldHead = head.next;
                newHead.prev = head;
                newHead.next = oldHead;
                head.next = newHead;
                oldHead.prev = newHead;
            }

            /**
             * 删除当前节点
             * @param node
             */
            public void remove(Node node) {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
            }

            /**
             * 删除链表中的最后一个节点
             * @return
             */
            public Node removeLast() {
                Node node = tail.prev;
                remove(node);
                return node;
            }
        }
    }

}
