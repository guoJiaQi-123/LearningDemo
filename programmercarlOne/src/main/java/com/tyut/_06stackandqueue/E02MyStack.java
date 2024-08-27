package com.tyut._06stackandqueue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/04/10
 * @apiNote 225.用队列实现栈 - 双队列模拟栈
 */
public class E02MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public E02MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }

    public int pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() != 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else if (!queue2.isEmpty()) {
            while (queue2.size() != 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
        return -1;
    }

    public int top() {
        if (!queue1.isEmpty()) {
            while (queue1.size() != 1) {
                queue2.offer(queue1.poll());
            }
            int peek = queue1.peek();
            queue2.offer(queue1.poll());
            return peek;
        } else if (!queue2.isEmpty()) {
            while (queue2.size() != 1) {
                queue1.offer(queue2.poll());
            }
            int peek = queue2.peek();
            queue1.offer(queue2.poll());
            return peek;
        }
        return -1;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    // 优化：使用一个队列模拟栈
    static class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        // 维护一个size记录队列中元素个数
        int size;

        public void push(int x) {
            queue.offer(x);
            // 将队列中前面的元素弹出再重新加入队列
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
            size++;
        }

        public int pop() {
            size--;
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
