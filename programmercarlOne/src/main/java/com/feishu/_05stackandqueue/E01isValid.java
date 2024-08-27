package com.feishu._05stackandqueue;

import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/8/9
 * @apiNote 20. 有效的括号
 */
public class E01isValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            // 遇到左括号，入队
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 遇到右括号，先判断此时队列是否为null
                // -如果为null，说明没有对应的左括号，不合法，返回false
                // -如果不为null，则判断栈顶左括号是否与栈顶右括号匹配，不匹配返回false
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if ((pop == '{' && c == '}') || (pop == '(' && c == ')') || (pop == '[' && c == ']')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        // 最后判断栈是否为null，然后不为null，说明有多余的左括号没有与之对应的右括号，返回false
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        // 创建一个栈
        Stack<Character> stack = new Stack<>();
        // 遍历字符串中的每一个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果字符是左括号，则将右括号压入栈中
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                // 如果字符是右括号，则判断栈顶元素是否与当前右括号相等
                if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
                } else {
                    // 如果没有对应的左括号，则返回false
                    return false;
                }
            }
        }
        // 如果栈为空，则返回true
        return stack.isEmpty();
    }
}
