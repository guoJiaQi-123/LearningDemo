package com.tyut._01array;

/**
 * @author OldGj 2024/03/12
 * @version v1.0
 * @apiNote 844. 比较含退格的字符串
 */
public class E09backspaceCompare {
    /*
                a#c

     */

    // 构造新字符串
    public boolean backspaceCompare(String s, String t) {
        String new_s = s(s);
        String new_t = s(t);
        System.out.println(new_s);
        System.out.println(new_t);
        return new_s.equals(new_t);
    }

    public String s(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '#') {
                sb.append(ch);
            } else {
                if (sb.length() == 0) {
                    continue;
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        E09backspaceCompare e09backspaceCompare = new E09backspaceCompare();
        boolean b = e09backspaceCompare.backspaceCompare2("ab#c", "ad#c");
        System.out.println(b);
    }

    // 指针倒叙扫描
    public boolean backspaceCompare2(String s, String t) {
        String new_s = m(s);
        String new_t = m(t);
        return new_s.equals(new_t);
    }

    public String m(String s) {
        int x = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '#') {
                x++;
            } else {
                if (x == 0) {
                    sb.append(ch);
                } else {
                    x--;
                }
            }
        }
        return sb.toString();
    }
}
