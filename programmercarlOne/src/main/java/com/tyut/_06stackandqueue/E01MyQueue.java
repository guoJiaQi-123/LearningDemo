package com.tyut._06stackandqueue;

import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/04/06
 * @apiNote 232. 用栈实现队列  -  双栈模拟队列
 */
class E01MyQueue {
    Stack<Integer> stackOut; // 负责出栈
    Stack<Integer> stackIn; // 负责进栈

    public E01MyQueue() {
        stackOut = new Stack<>();
        stackIn = new Stack<>();
    }

    // 向队列尾部添加
    public void push(int x) {
        stackIn.push(x);
    }

    // 从队列头移除
    public int pop() {
        // 队列的pop方法，看出栈是否为null，如果为null，则将进栈中的元素pop加入到出栈中
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop()); // 将进栈中的元素添加到出栈
            }
        }
        return stackOut.pop();
    }

    public int peek() {
        // 队列的peek方法，看出栈是否为null，如果为null，则将进栈中的元素pop加入到出栈中
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop()); // 将进栈中的元素添加到出栈
            }
        }
        return stackOut.peek();
    }

    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }

}
