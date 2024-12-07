package com.feishu._09DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/12/7
 * @apiNote 22. 括号生成
 */
public class E16generateParenthesis {
    /*
        0   ''
        1   ()
        2   ()()    (())
        3   ()()()  ()(())  (())()  (()())  ((()))
     */
    public List<String> generateParenthesis(int n) {
        ArrayList<String>[] dp = new ArrayList[n + 1];
        // 初始化
        dp[0] = new ArrayList<>(List.of(""));
        dp[1] = new ArrayList<>(List.of("()"));
        // 卡特兰数
        for (int i = 2; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                // 拼接每种可能出现的结果
                for (String x : dp[j]) {
                    for (String y : dp[i - 1 - j]) {
                        dp[i].add("(" + x + ")" + y);
                    }
                }
            }
        }
        return dp[n];
    }
}
