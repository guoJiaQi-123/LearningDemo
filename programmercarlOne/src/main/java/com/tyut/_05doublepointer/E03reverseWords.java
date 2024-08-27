package com.tyut._05doublepointer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author OldGj 2024/03/31
 * @version v1.0
 * @apiNote 151. 反转字符串中的单词
 */
public class E03reverseWords {
    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        // 定义一个栈，第一次遍历压栈
        Stack<String> stack = new Stack<>();
        for (char c : charArray) {
            if (c != ' ') { // 解决前导空格，只有不为' '时才拼字符串
                sb.append(c);
            }
            if (c == ' ') { // 第二次遇到' '说明已经遍历了一个单词
                if (sb.length() != 0) {
                    stack.push(sb.toString()); // 单词入栈
                    sb.delete(0, sb.length()); // 字符串清零
                }
            }
        }
        // 将最后一次字符串中的单词入栈
        if (sb.length() != 0) {
            stack.push(sb.toString());
            sb.delete(0, sb.length());
        }
        // 遍历完成后出栈顺序即为逆序
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            // 栈不为空，需要拼' '隔开单词
            if (!stack.isEmpty()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
