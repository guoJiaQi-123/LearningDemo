package com.feishu._01array;

/**
 * @version v1.0
 * @author OldGj 2024/7/13
 * @apiNote 844. 比较含退格的字符串
 */
public class E06backspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        String ss = delete(s); // 删除#后的字符串
        String tt = delete(t);
        return ss.equals(tt);
    }

    private String delete(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#') {
                sb.append(c); // 如果字符不是#则拼接
            } else {
                if (sb.length() > 0) { // 在StringBuilder长度大于0的情况下
                    sb.deleteCharAt(sb.length() - 1); // 如果字符是#则删除最后一个新拼接的字符
                }
            }
        }
        return sb.toString();
    }

    /*
        一个字符是否会被删掉，只取决于该字符后面的退格符，而与该字符前面的退格符无关。因此当我们逆序地遍历字符串，就可以立即确定当前字符是否会被删掉。
        字符串倒叙扫描：将字符串从后向前扫描，如果扫描到#则将变量X++，X记录当前状态下有#的数量
        如果遍历到非#，则判断X是否为0，如果为0，说明这个字符需要拼接，反之，说明这个字符被退格，只需将X--即可
        通过toS方法获取的字符串，就是原字符串在执行完成#退格后的结果并且逆序的新字符串
     */
    public boolean backspaceCompare2(String s, String t) {
        String new_s = toS(s);
        String new_t = toS(t);
        return new_s.equals(new_t);
    }

    private String toS(String s) {
        int skip = 0; // 记录当前的#数量
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '#') {
                skip++;
            } else {
                if (skip == 0) {
                    sb.append(ch);
                } else {
                    skip--;
                }
            }
        }
        return sb.toString();
    }
}
