package com.feishu._01array;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/7/15
 * @apiNote 904. 水果成篮
 */
public class E11totalFruit {
    /*
        滑动窗口
     */
    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0; // 滑动窗口的起始位置
        int result = 0;
        for (int right = 0; right < len; right++) { // 滑动窗口的终止位置
            // 使用哈希表存储这个窗口内的数以及出现的次数 【出现的数-出现的次数】
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) { // 因为果篮只有两个，当出现的数超过三个，就需要移动起始位置，缩小窗口
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) { // 如果窗口的起始位置移动到某个数全部的右面，从哈希表删除这个数
                    map.remove(fruits[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
