package com.tyut._06stackandqueue;


import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/04/14
 * @apiNote 1047. 删除字符串中的所有相邻重复项
 */
public class E04removeDuplicates {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
//        StringBuilder sb = new StringBuilder();
//        stack.forEach(sb::append);
        String str = "";
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        return str;
    }

    // 使用字符串直接作为栈，省去了栈还要转字符串的操作
    public String removeDuplicates2(String s) {
        // 将 res 当做栈
        // 也可以用 StringBuilder 来修改字符串，速度更快
        // StringBuilder res = new StringBuilder();
        StringBuilder res = new StringBuilder();
        // top为 res 的长度
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当 top > 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
                // 否则，将该字符 入栈，同时top++
            } else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }
}
