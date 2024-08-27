package com.feishu._03hashtable;

/**
 * @version v1.0
 * @author OldGj 2024/8/2
 * @apiNote 383. 赎金信
 */
public class E06canConstruct {

    /*
        直接使用数组作为哈希表，数组的下标索引作为对应的字符，数组中的值作为字符出现的次数
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        // 在ransomNote中出现的字符对应的值使数组++
        for (char c : ransomNote.toCharArray()) {
            arr[c - 'a']++;
        }
        // 在magazine中出现的字符对应的值使数组--
        for (char c : magazine.toCharArray()) {
            arr[c - 'a']--;
        }
        // 如果最终数组中存在大于0的数，说明ransomNote中该字符出现次数大于magazine
        // 则不能构成ransomNote，返回false
        for (int i : arr) {
            if (i > 0) {
                return false;
            }
        }
        // 若所有值都小于0，则返回true
        return true;
    }
}
