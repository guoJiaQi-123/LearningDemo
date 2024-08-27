package com.tyut._03hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author OldGj 2024/03/20
 * @version v1.0
 * @apiNote 242. 有效的字母异位词
 */
public class E01isAnagram {

    /*
        遍历S的时候在大小为26的数组中将对应索引的值++，遍历T的时候--，看最后数组是否为0
     */
    public boolean isAnagram(String s, String t) {
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ints[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            ints[c - 'a']--;
        }
        int count = 0;
        for (int anInt : ints) {
            if (anInt == 0) {
                count++;
            }
        }
        return count == 26;
    }

    /*
            转换为字符数组排序后比较字符数组
     */
    public boolean isAnagram2(String s, String t) {
        char[] charArray = s.toCharArray();
        char[] charArray1 = t.toCharArray();
        Arrays.sort(charArray);
        Arrays.sort(charArray1);
        String s1 = Arrays.toString(charArray);
        String s2 = Arrays.toString(charArray1);
        return s1.equals(s2);
    }

    /*
        字符打散放入int[26]数组，数组中记录字母出现的次数，最后比较数组
     */
    public boolean isAnagram3(String s, String t) {
        return Arrays.equals(toArray(s), toArray(t));
    }

    private int[] toArray(String t) {
        int[] arr = new int[26];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            arr[c - 'a']++;
        }
        return arr;
    }
}
