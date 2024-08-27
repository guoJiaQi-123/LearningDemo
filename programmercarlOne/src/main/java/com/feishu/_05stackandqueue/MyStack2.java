package com.feishu._05stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version v1.0
 * @author OldGj 2024/8/9
 * @apiNote 225. 用队列实现栈
 */
public class MyStack2 {

    // 用一个队列实现栈
    Queue<Integer> queue;

    public MyStack2() {
        queue = new LinkedList<>();
    }

    // 入栈
    public void push(int x) {
        // 将元素先加入队列尾部
        queue.offer(x);
        // 将刚加入队列的元素前面的元素全部出队再入队
        int size = queue.size();
        while (size != 1) {
            queue.offer(queue.poll());
            size--;
        }
        // 通过上面的操作，刚加入的元素就被放置在队列头了
    }

    // 出栈
    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
