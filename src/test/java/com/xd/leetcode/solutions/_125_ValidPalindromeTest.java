package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _125_ValidPalindromeTest {
    _125_ValidPalindrome v;
    String[] input;
    boolean[] expect;

    _125_ValidPalindromeTest() {
        v = new _125_ValidPalindrome();
        input = new String[]{"ab@a", "ab", "A man, a plan, a canal: Panama", "race a car"};
        expect = new boolean[]{true, false, true, false};
    }

    @Test
    void isPalindrome() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], v.isPalindrome(input[i]));
        }
    }
}