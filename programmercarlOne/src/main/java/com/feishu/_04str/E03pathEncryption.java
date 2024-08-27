package com.feishu._04str;

/**
 * @version v1.0
 * @author OldGj 2024/8/5
 * @apiNote LCR 122. 路径加密
 */
public class E03pathEncryption {
    public String pathEncryption(String path) {
        char[] arr = path.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '.') {
                arr[i] = ' ';
            }
        }
        return new String(arr);
    }

    public String pathEncryption2(String path) {
        char[] arr = path.toCharArray();
        StringBuilder res = new StringBuilder();
        for (char c : arr) {
            if (c == '.') {
                res.append(" ");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
