package com.feishu._05stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/8/9
 * @apiNote 225. 用队列实现栈
 */
class MyStack {

    Queue<Integer> queue1; // 主队列
    Queue<Integer> queue2; // 辅助队列


    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // 压栈
    public void push(int x) {
        // 先将主队列中的元素全部加入辅助队列
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // 将待加入元素加入主队列
        queue1.offer(x);
        // 再将辅助队列中的元素加入主队列
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        // 通过上面的操作，待加入元素一开始即被加入到主队列头
    }

    // 出栈
    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}