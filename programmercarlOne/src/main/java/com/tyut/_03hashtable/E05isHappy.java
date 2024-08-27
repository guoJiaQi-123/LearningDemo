package com.tyut._03hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author OldGj 2024/03/21
 * @version v1.0
 * @apiNote 202. 快乐数
 */
public class E05isHappy {
    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int totalSum = 0;
        String s = String.valueOf(n);
        while (totalSum != 1) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int anInt = Integer.parseInt(String.valueOf(c));
                sum += anInt * anInt;
            }
            if (map.containsKey(sum)) { // 如果sum已经存在在map，说明这是一个死循环，对应的n不是快乐数
                return false;
            }
            totalSum = sum;
            map.put(sum, 1);
            s = String.valueOf(totalSum);
        }
        // 如果totalSum可以为1，则跳出上面的循环，返回true
        return true;
    }

    // 性能更好
    public boolean isHappy2(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) { // 如果一个数存在在set集合中，说明之前已经处理过该数，这是一个死循环
            record.add(n);
            n = getNextNumber(n); // 获取下个数
        }
        return n == 1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10; // 拿到个位数
            res += temp * temp; // 计算res结果
            n = n / 10; // 去除个位数
        }
        return res;
    }

    public static void main(String[] args) {
        E05isHappy e05isHappy = new E05isHappy();
        boolean happy = e05isHappy.isHappy(2);
        System.out.println(happy);
    }
}
