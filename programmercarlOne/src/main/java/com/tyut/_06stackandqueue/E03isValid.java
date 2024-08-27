package com.tyut._06stackandqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/04/14
 * @apiNote 20. 有效的括号
 */
public class E03isValid {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : charArray) {
            //  ({})
            //  ((){{}})
            if (stack.isEmpty() && (ch == ')' || ch == ']' || ch == '}')) {
                return false;
            }
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if ((ch == ')' && stack.peek() == '(') || (ch == '}' && stack.peek() == '{') || (ch == ']' && stack.peek() == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
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
