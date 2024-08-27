package com.tyut._04string;

import java.util.LinkedList;

/**
 * @author OldGj 2024/03/27
 * @version v1.0
 * @apiNote 151. 反转字符串中的单词
 */
public class E04reverseWords {
    public String reverseWords(String s) {
        // 定义一个栈，第一次遍历压栈
        LinkedList<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
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
        StringBuilder res = new StringBuilder();
        // 遍历完成后出栈顺序即为逆序
        while (!stack.isEmpty()) {
            res.append(stack.pop());
            // 栈不为空，需要拼' '隔开单词
            if (!stack.isEmpty()) {
                res.append(' ');
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        E04reverseWords e04reverseWords = new E04reverseWords();
        String s = e04reverseWords.reverseWords("a good   example");
        System.out.println(s);
    }
}
