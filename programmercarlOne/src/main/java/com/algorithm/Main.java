package com.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2024/9/9
 * @apiNote TODO(一句话给出该类描述)
 */
public class Main {

    public static Integer func(List<Integer> list) {
        if (list.size() == 0 || list == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : list) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1); 
            } else {
                map.put(i, 1);
            }
        }
        for (Integer i : list) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return null;
    }

    public static Integer func2(List<Integer> list) {
        int[] array = list.stream()
                .distinct()
                .mapToInt(Integer::intValue)
                .toArray();
        return array[0];
    }
}
