package com.feishu._04str;

import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/8/8
 * @apiNote 151. 反转字符串中的单词
 */
public class E08reverseWords {
    /*
        使用栈数据结构实现字符串中单词的反转
     */
    public String reverseWords(String s) {
        // 定义一个栈数据结构，第一次遍历时将单词入栈，全部入栈后出栈顺序即为逆序
        Stack<String> stack = new Stack<>();
        // 使用StringBuilder拼接字符串
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c != ' ') {
                sb.append(c); // 解决前导空格的问题，只有在c不等于' '时才拼接
            }
            // 如果c在sb不为0时等于了' '说明此时已经拼接完了一个单词
            if (c == ' ' && sb.length() != 0) {
                // 将单词入栈，然后清空sb
                stack.push(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        // 如果字符串后面没有后导空格，那么最后一个单词将不会入栈，因此需要格外判断
        if (sb.length() != 0) {
            stack.push(sb.toString());
        }
        // 将栈中的单词依次出栈，然后拼接，并且在栈不为空时每个单词后面拼接一个' '
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
            if (!stack.isEmpty()) {
                res.append(' ');
            }
        }
        return res.toString();
    }
}
