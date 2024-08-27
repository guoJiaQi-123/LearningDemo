package com.LeetCode.December_2023;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day1_twoSumTest {

    @Test
    @DisplayName("测试两数之和-哈希表实现")
    void twoSum() {
        int[] exception = new int[]{0,1};
        int[] targetArr = new int[]{3,3};
        int target = 6;
        assertArrayEquals(exception,Day1_twoSum.twoSum(targetArr,target));
    }

    @Test
    @DisplayName("测试两数之和-暴力递归")
    void twoSum2() {
        int[] exception = new int[]{0,1};
        int[] targetArr = new int[]{3,3};
        int target = 6;
        assertArrayEquals(exception,Day1_twoSum.twoSum(targetArr,target));
    }
}