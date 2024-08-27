package com.feishu._03hashtable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @version v1.0
 * @author OldGj 2024/8/1
 * @apiNote 202. 快乐数
 */
public class E03isHappy {
    public boolean isHappy(int n) {
        // 使用一个set集合判断是否进入死循环
        Set<Integer> record = new HashSet<>();
        // 当一个值没有在set中出现时加入set，如果这个值在set集合中重复出现，则说明进入了死循环
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    private int getNextNum(int n) {
        int sum = 0;
        // 从个位数开始依次遍历n中的每一位
        while (n != 0) {
            int i = n % 10; // 获取个位数
            sum += i * i; // 计算个位数的平方并加到sum和上
            n /= 10; // 去除个位数
        }
        return sum;
    }

}
