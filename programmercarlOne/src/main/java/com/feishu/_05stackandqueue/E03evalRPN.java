package com.feishu._05stackandqueue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/8/9
 * @apiNote 150. 逆波兰表达式求值
 */
public class E03evalRPN {
    public int evalRPN(String[] tokens) {
        // 使用栈数据结构，遍历字符如果为数字，则入栈，如果为符号，则将栈顶两个元素弹出后做运算，再将结果入栈
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(s)) { // 注意 - 和/ 需要特殊处理，需要注意顺序
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        // 最后返回栈内唯一一个值就是结果
        return stack.pop();
    }

}
