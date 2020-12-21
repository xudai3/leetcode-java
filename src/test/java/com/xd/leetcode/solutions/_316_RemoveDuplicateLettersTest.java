package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _316_RemoveDuplicateLettersTest {
    _316_RemoveDuplicateLetters r;
    String[] input;
    String[] expect;

    public _316_RemoveDuplicateLettersTest() {
        r = new _316_RemoveDuplicateLetters();
        input = new String[]{"bcabc", "cbacdcbc"};
        expect = new String[]{"abc", "acdb"};
    }

    @Test
    void removeDuplicateLetters() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], r.removeDuplicateLetters(input[i]));
        }
    }
}