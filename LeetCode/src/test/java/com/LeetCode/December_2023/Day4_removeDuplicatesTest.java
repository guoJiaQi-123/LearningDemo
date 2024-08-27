package com.LeetCode.December_2023;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day4_removeDuplicatesTest {

    @Test
    void removeDuplicates() {
        int[] a = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = Day4_removeDuplicates.removeDuplicates2(a);
        assertEquals(5,i);
    }

    @Test
    void removeDuplicates2() {
        int[] a = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = Day4_removeDuplicates.removeDuplicates2(a);
        assertEquals(5,i);
    }
}