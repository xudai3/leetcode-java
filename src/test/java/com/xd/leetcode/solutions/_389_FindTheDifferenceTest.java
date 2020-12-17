package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _389_FindTheDifferenceTest {
    class TestCases {
        String[] s;
        String[] t;
        char[] expect;
    }
    TestCases testCases;
    _389_FindTheDifference f;
    public _389_FindTheDifferenceTest() {
        testCases = new TestCases();
        f = new _389_FindTheDifference();
        testCases.s = new String[]{"abcd", "", "a", "ae"};
        testCases.t = new String[]{"abcde", "y", "aa", "aea"};
        testCases.expect = new char[]{'e', 'y', 'a', 'a'};
    }

    @Test
    void findTheDifferenceHash() {
        for (int i = 0; i < testCases.s.length; i++) {
            assertEquals(testCases.expect[i], f.findTheDifferenceHash(testCases.s[i], testCases.t[i]));
        }
    }
    @Test
    void findTheDifferenceXOR() {
        for (int i = 0; i < testCases.s.length; i++) {
            assertEquals(testCases.expect[i], f.findTheDifferenceXOR(testCases.s[i], testCases.t[i]));
        }
    }
}
