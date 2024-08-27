package com.feishu._05stackandqueue;

import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/8/9
 * @apiNote 1047. 删除字符串中的所有相邻重复项
 */
public class E02removeDuplicates {
    // 使用栈数据结构
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (char ch : array) {
            // 如果栈不为null并且栈顶元素与当前遍历到的元素相等，则弹栈
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                // 否则将当前遍历到的元素压栈
                stack.push(ch);
            }
        }
        // 最后将出栈后的字符反转后返回
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    // 双指针
    public String removeDuplicates2(String s) {
        char[] ch = s.toCharArray();
        int fast = 0; // 快指针
        int slow = 0; // 慢指针
        while(fast < s.length()){
            // 直接用fast指针覆盖slow指针的值
            ch[slow] = ch[fast];
            // 遇到前后相同值的，slow指针后退一步，指向重复指针的第一个值，下次循环就可以直接被覆盖掉了
            if(slow > 0 && ch[slow] == ch[slow - 1]){
                slow--;
            }else{
                slow++;
            }
            fast++;
        }
        return new String(ch,0,slow);
    }
}
