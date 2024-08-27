package com.feishu._03hashtable;

/**
 * @version v1.0
 * @author OldGj 2024/8/1
 * @apiNote 242. 有效的字母异位词
 */
public class E01isAnagram {

    /*
        数组就是特殊的哈希表，此题利用数组巧妙记录字符出现的次数解决
     */
    public boolean isAnagram(String s, String t) {
        // 定义一个长度为26的数组，每个索引下都记录一个字符出现的次数
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // 获得S串中的一个字符
            arr[c - 'a']++; // 将该字符对应的索引处的值++，对应关系a->0，b->1...z->25
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i); // 获得t串中的一个字符
            arr[c - 'a']--; // 将该字符对应的索引处的值--，如果s和t是字母异位词，则最后数组的所有值均为0
        }
        // 判断数组中的值是否全部为0，如果有一个不为0，则说明s和t不是字母异位词，返回false
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
