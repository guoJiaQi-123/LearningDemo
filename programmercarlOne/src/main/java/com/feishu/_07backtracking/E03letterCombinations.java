package com.feishu._07backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/9/3
 * @apiNote 17. 电话号码的字母组合
 */
public class E03letterCombinations {
    List<String> res = new ArrayList<>(); // 存放最终的结果集合
    StringBuilder temp = new StringBuilder(); // 每个结果

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        // 数字和字符串的映射关系，比如数组下标为2时，numString[2] == "abc"
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // 递归
        dfs(digits, numString, 0);
        return res;
    }

    /**
     *
     * @param digits 题目的参数，比如”23”
     * @param numString 数字和字符串的映射关系
     * @param i 当前正在处理的字符串的索引 比如0，则表示正在处理 digits的第一个字符串，也是就2对应的字符串‘abc’
     */
    private void dfs(String digits, String[] numString, int i) {
        // 如果i==digits.length()说明digits中的所有字符串都处理完成了
        if (digits.length() == i) {
            // 将结果加入集合
            res.add(temp.toString());
            return;
        }
        // 取当前应该处理的字符串
        // digits.charAt(i)表示取参数中的数字，比如“2”  -'0'操作将其转化为2~9范围内的int类型
        // numString[digits.charAt(i) - '0']; 则表示在映射关系中取当前数字对应的字符串
        String str = numString[digits.charAt(i) - '0'];
        for (int j = 0; j < str.length(); j++) {
            temp.append(str.charAt(j));
            dfs(digits, numString, i + 1); // 取下一个字符串一个一个处理
            // 比如“digits”为“23”，则先取2对应的字符串“abc”，然后固定'a'，递归处理3对应的字符串'def',固定'd'，则返回'ad'
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
