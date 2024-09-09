package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/9/9
 * @apiNote TODO(一句话给出该类描述)
 */
public class Main2 {

    public static void main(String[] args) {
        Integer func = func(List.of(1, 2, 2, 5, 3, 5, 8, 11), 2);
        System.out.println(func);
    }

    /*
        1   2   2  3  5      5   8  [11]           K = 2
     */
    public static Integer func(List<Integer> list, int K) {
        if (list == null) {
            return null;
        }
        // 先将数组排序
        int[] array = list.stream().sorted().mapToInt(Integer::intValue).toArray();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int curr = array[i];
            // 判断第一个元素是否符合条件
            if (i == 0) {
                int next = array[i + 1];
                if (next - curr > K) {
                    res.add(curr);
                }
            }
            // 判断最后一个元素是否符合条件
            if (i == array.length - 1) {
                int prev = array[i - 1];
                if (curr - prev > K) {
                    res.add(curr);
                }
            }
            // 判断中间的元素是否符合条件
            if (i > 0 && i < array.length - 1) {
                int prev = array[i - 1];
                int next = array[i + 1];
                if (curr - prev > K && next - curr > K) {
                    res.add(curr);
                }
            }
        }
        // 在原先的数组中找第一个符合条件的
        for (Integer i : list) {
            if (res.contains(i)) {
                return i;
            }
        }
        return null;
    }



}
