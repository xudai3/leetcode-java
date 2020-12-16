package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _290_WordPatternTest {
    class TestCases {
        String[] pattern;
        String[] str;
        boolean[] expect;
    }
    _290_WordPattern w;
    TestCases testCases;
    public _290_WordPatternTest() {
        w = new _290_WordPattern();
        testCases = new TestCases();
        testCases.pattern = new String[]{"abba","abba","aaaa","abba"};
        testCases.str = new String[]{"dog cat cat dog","dog cat cat fish","dog cat cat dog","dog dog dog dog"};
        testCases.expect = new boolean[]{true, false, false, false};
    }
    @Test
    void wordPatternOneMap() {
        for (int i = 0; i < testCases.pattern.length; i++) {
            assertEquals(testCases.expect[i], w.wordPatternOneMap(testCases.pattern[i], testCases.str[i]));
        }
    }
    @Test
    void wordPatternTwoMap() {
        for (int i = 0; i < testCases.pattern.length; i++) {
            assertEquals(testCases.expect[i], w.wordPatternTwoMap(testCases.pattern[i], testCases.str[i]));
        }
    }
}