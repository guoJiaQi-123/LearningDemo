package com.feishu._07backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/9/7
 * @apiNote 131. 分割回文串
 */
public class E06partition {


    //保持前几题一贯的格式， initialization
    List<List<String>> res = new ArrayList<>();
    List<String> cur = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0, new StringBuilder());
        return res;
    }

    private void backtracking(String s, int start, StringBuilder sb) {
        //因为是起始位置一个一个加的，所以结束时start一定等于s.length,因为进入backtracking时一定末尾也是回文，所以cur是满足条件的
        if (start == s.length()) {
            //注意创建一个新的copy
            res.add(new ArrayList<>(cur));
            return;
        }
        //像前两题一样从前往后搜索，如果发现回文，进入backtracking,起始位置后移一位，循环结束照例移除cur的末位
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (check(sb)) {
                cur.add(sb.toString());
                backtracking(s, i + 1, new StringBuilder());
                cur.remove(cur.size() - 1);
            }
        }
    }

    //helper method, 检查是否是回文
    private boolean check(StringBuilder sb) {
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    static class Solution {
        List<List<String>> result;
        LinkedList<String> path;
        boolean[][] dp;

        public List<List<String>> partition(String s) {
            result = new ArrayList<>();
            char[] str = s.toCharArray();
            path = new LinkedList<>();
            dp = new boolean[str.length + 1][str.length + 1];
            isPalindrome(str);
            backtracking(s, 0);
            return result;
        }

        public void backtracking(String str, int startIndex) {
            if (startIndex >= str.length()) {
                //如果起始位置大于s的大小，说明找到了一组分割方案
                result.add(new ArrayList<>(path));
            } else {
                for (int i = startIndex; i < str.length(); ++i) {
                    if (dp[startIndex][i]) {
                        //是回文子串，进入下一步递归
                        //先将当前子串保存入path
                        path.addLast(str.substring(startIndex, i + 1));
                        //起始位置后移，保证不重复
                        backtracking(str, i + 1);
                        path.pollLast();
                    } else {
                        //不是回文子串，跳过
                        continue;
                    }
                }
            }
        }

        //通过动态规划判断是否是回文串,参考动态规划篇 52 回文子串
        public void isPalindrome(char[] str) {
            for (int i = 0; i <= str.length; ++i) {
                dp[i][i] = true;
            }
            for (int i = 1; i < str.length; ++i) {
                for (int j = i; j >= 0; --j) {
                    if (str[j] == str[i]) {
                        if (i - j <= 1) {
                            dp[j][i] = true;
                        } else if (dp[j + 1][i - 1]) {
                            dp[j][i] = true;
                        }
                    }
                }
            }
        }
    }
}
