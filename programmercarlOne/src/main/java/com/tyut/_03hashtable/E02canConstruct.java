package com.tyut._03hashtable;

/**
 * @author OldGj 2024/03/20
 * @version v1.0
 * @apiNote 383. 赎金信
 */
public class E02canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        int[] arr1 = new int[26];
        char[] charArray = magazine.toCharArray();
        for (char c : charArray) {
            arr[c - 'a']++;
        }
        char[] charArray1 = ransomNote.toCharArray();
        for (char c : charArray1) {
            arr1[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] < arr1[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] arr = new int[26];
        char[] charArray = magazine.toCharArray();
        for (char c : charArray) {
            arr[c - 'a']++;
        }
        char[] charArray1 = ransomNote.toCharArray();
        for (char c : charArray1) {
            arr[c - 'a']--;
        }
        for (int i : arr) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
