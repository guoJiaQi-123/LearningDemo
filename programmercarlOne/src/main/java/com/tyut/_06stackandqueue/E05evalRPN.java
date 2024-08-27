package com.tyut._06stackandqueue;

import java.util.Stack;

/**
 * @version v1.0
 * @author OldGj 2024/04/15
 * @apiNote 150. 逆波兰表达式求值
 */
public class E05evalRPN {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        int res = 0;
        for (String ch : tokens) {
            switch (ch) {
                case "+" -> {
                    String pop1 = stack.pop();
                    String pop2 = stack.pop();
                    res = (Integer.parseInt(pop1) + Integer.parseInt(pop2));
                    stack.push(Integer.toString(res));
                }
                case "-" -> {
                    String pop1 = stack.pop();
                    String pop2 = stack.pop();
                    res = (Integer.parseInt(pop2) - Integer.parseInt(pop1));
                    stack.push(Integer.toString(res));
                }
                case "*" -> {
                    String pop1 = stack.pop();
                    String pop2 = stack.pop();
                    res = (Integer.parseInt(pop1) * Integer.parseInt(pop2));
                    stack.push(Integer.toString(res));
                }
                case "/" -> {
                    String pop1 = stack.pop();
                    String pop2 = stack.pop();
                    res = (Integer.parseInt(pop2) / Integer.parseInt(pop1));
                    stack.push(Integer.toString(res));
                }
                default -> {
                    stack.push(ch);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        E05evalRPN e05evalRPN = new E05evalRPN();
        String[] token = new String[]{"4", "13", "5", "/", "+"};
        int i = e05evalRPN.evalRPN(token);
        System.out.println(i);
    }
}
