package com.tyut._01array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author OldGj 2024/03/12
 * @version v1.0
 * @apiNote 904. 水果成篮
 */
public class E12totalFruit {

    // 滑动窗口
    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        // 定义一个哈希表用于存放窗口内的数以及该数出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 左窗口
        int left = 0;
        int result = 0;
        // 右窗口
        for (int right = 0; right < len; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            // 如果哈希表中出现超过两个键值对，那么我们需要不断移动left，并将fruits[left]从哈希表中移除
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        E12totalFruit e12totalFruit = new E12totalFruit();
        int i = e12totalFruit.totalFruit(new int[]{1, 2, 1});
        System.out.println(i);
    }
}
