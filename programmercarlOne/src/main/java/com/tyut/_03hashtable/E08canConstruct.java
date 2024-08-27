package com.tyut._03hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author OldGj 2024/03/25
 * @version v1.0
 * @apiNote 383. 赎金信
 */
public class E08canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] sourceArray = ransomNote.toCharArray();
        char[] charArray = magazine.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : sourceArray) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] arr = new int[26];
        char[] sourceArray = ransomNote.toCharArray();
        char[] charArray = magazine.toCharArray();
        for (char c : charArray) {
            arr[c - 'a']++;
        }
        for (char c : sourceArray) {
            arr[c - 'a']--;
            if (arr[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
