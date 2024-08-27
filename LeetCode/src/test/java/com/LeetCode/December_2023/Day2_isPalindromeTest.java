package com.LeetCode.December_2023;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day2_isPalindromeTest {

    @Test
    void isPalindrome() {

        assertEquals(true,Day2_isPalindrome.isPalindrome(121));
        assertEquals(false,Day2_isPalindrome.isPalindrome(452));
        assertEquals(true,Day2_isPalindrome.isPalindrome(458854));
        assertEquals(false,Day2_isPalindrome.isPalindrome(45324));
        assertEquals(true,Day2_isPalindrome.isPalindrome(899636998));

    }

    @Test
    void isPalindrome2() {

        assertEquals(true,Day2_isPalindrome.isPalindrome2(121));
        assertEquals(false,Day2_isPalindrome.isPalindrome2(452));
        assertEquals(true,Day2_isPalindrome.isPalindrome2(458854));
        assertEquals(false,Day2_isPalindrome.isPalindrome2(45324));
        assertEquals(true,Day2_isPalindrome.isPalindrome2(899636998));
    }
}