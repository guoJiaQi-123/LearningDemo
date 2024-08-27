package com.feishu._05stackandqueue;

import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/8/9
 * @apiNote 232. 用栈实现队列
 */
public class MyQueue {

    Stack<Integer> stackIn; // 负责进栈
    Stack<Integer> stackOut; // 负责出栈

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // 向队列尾部添加
    public void push(int x) {
        stackIn.push(x); // 将加入元素加入进栈
    }

    // 从队列头部移除
    public int pop() {
        // 如果出栈为null，则将进栈中的元素加入出栈
        dumpStackIn();
        return stackOut.pop();
    }

    public int peek() {
        // 如果出栈为null，则将进栈中的元素加入出栈
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    /*
        如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
     */
    private void dumpStackIn() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
}
