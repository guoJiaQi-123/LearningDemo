package com.feishu._04str;

/**
 * @version v1.0
 * @author OldGj 2024/8/5
 * @apiNote LCR 182. 动态口令
 */
public class E04dynamicPassword {
    public String dynamicPassword(String password, int target) {
        // 缓存0~target的字符
        String sub = password.substring(0, target);
        char[] arr = password.toCharArray();
        int len = arr.length;
        // 将target后面的字符移动到前面
        for (int i = 0; i < len - target; i++) {
            arr[i] = arr[target + i];
        }
        int t = 0;
        // 将提前缓存的字符加到后面
        for (int i = len - target; i < len; i++) {
            arr[i] = sub.charAt(t++);
        }
        return new String(arr);
    }

    /*
        字符串切片
     */
    public String dynamicPassword2(String password, int target) {
        return password.substring(target) + password.substring(0, target);
    }
}
