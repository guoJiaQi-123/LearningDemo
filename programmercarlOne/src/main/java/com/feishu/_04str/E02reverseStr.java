package com.feishu._04str;

/**
 * @version v1.0
 * @author OldGj 2024/8/5
 * @apiNote 541. 反转字符串 II
 */
public class E02reverseStr {

    /*
        从0开始，每隔2K个字符进行处理，处理方式：
        前K个字符反转，后K个字符不反转
     */
    public String reverseStr(String s, int k) {
        // 结果字符串
        StringBuilder res = new StringBuilder();
        // 从0开始，每次 start += 2 * k
        int start = 0;
        int len = s.length();
        while (start < len) {
            // 存放一个2K中的字符
            StringBuilder sb = new StringBuilder();
            // 找到k处和2k处，如果超过了字符串长度，则取字符串长度
            int firstK = Math.min(start + k, len);
            int secondK = Math.min(start + 2 * k, len);
            // 将前k个加入sb
            sb.append(s, start, firstK);
            // 反转前K个字符
            sb.reverse();
            // 如果K-2K仍然存在字符，则加入sb
            if (firstK < secondK) {
                sb.append(s, firstK, secondK);
            }
            // 将一个2K范围内的字符拼接到最终的结果中
            res.append(sb);
            // 每次 start += 2 * k
            start += 2 * k;
        }
        return res.toString();
    }

    public String reverseStr2(String s, int k) {
        char[] ch = s.toCharArray();
        // 1. 每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i < ch.length; i += 2 * k) {
            // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if (i + k <= ch.length) {
                reverse(ch, i, i + k - 1);
                continue;
            }
            // 3. 剩余字符少于 k 个，则将剩余字符全部反转
            reverse(ch, i, ch.length - 1);
        }
        return new String(ch);

    }

    // 定义翻转函数
    public void reverse(char[] ch, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }

    }
}
