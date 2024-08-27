package com.LeetCode.December_2023;

import java.util.HashMap;
import java.util.Map;

//两数之和
public class Day1_twoSum {

    /**
     * 利用哈希表 时间复杂度 O( n )
     */
    public static int[] twoSum(int[] nums, int target) {
        //定义一个变量存放数组长度
        int len = nums.length;
        //定义一个哈希表，对应的Key —— Value分别指：Key-数组中的数值    Value-该值对应的数组下标
        Map<Integer,Integer> map = new HashMap<>(len-1);
        //循环该数组
        for(int i = 0; i<len;i++){
            //如果在哈希表中存在符合要求（目标值-当前遍历的值）的值，则返回该值对应的Value（数组下标）与当前遍历的值的数组下标组成的新数组
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }
            //如果哈希表中没有符合要求的值，则将当前遍历的值存放进哈希表
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("数组中没有两数和为目标值");
    }

    /**
     * 暴力枚举 时间复杂度 O( n^2 )
     */
    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        //暴力递归
        for(int i=0; i < len-1; i++){
            int x = nums[i];
            for(int j = i + 1;j < len; j++){
                int y = nums[j];
                if(x + y == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("数组中没有两数和为目标值");
    }
}
