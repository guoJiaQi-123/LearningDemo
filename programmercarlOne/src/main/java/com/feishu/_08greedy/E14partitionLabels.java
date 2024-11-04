package com.feishu._08greedy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @version v1.0
 * @author OldGj 2024/11/4
 * @apiNote 763. 划分字母区间
 */
public class E14partitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        // 用长26的数组作为a~z的map,0->a,1->b ... 25->z
        int[] map = new int[26];
        char[] array = s.toCharArray();
        // 第一次遍历，找到每个字符对应的最左下标
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            map[c - 'a'] = i;
        }
        int max = 0;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            // 第二次遍历，max始终等于当前遍历过的所有字符中的最左下标
            max = Math.max(max, map[c - 'a']);
            // 一旦i等于了当前 遍历过的所有的字符中的最左下标，说明找到了一个分割点
            if (i == max) {
                // 添加字符串的长度，并且记录当前坐标
                res.add(i - index);
                index = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new E14partitionLabels().partitionLabels("ababcbacadefegdehijhklij");
    }
}
