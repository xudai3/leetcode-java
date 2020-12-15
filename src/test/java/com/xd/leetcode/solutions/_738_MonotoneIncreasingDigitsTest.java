package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _738_MonotoneIncreasingDigitsTest {
    class TestCases {
        int[] input;
        int[] expect;
    }
    TestCases testCases;
    _738_MonotoneIncreasingDigits m;
    public _738_MonotoneIncreasingDigitsTest() {
        m = new _738_MonotoneIncreasingDigits();
        testCases = new TestCases();
        testCases.input = new int[]{1234,1234321,2333332};
        testCases.expect = new int[]{1234,1233999,2299999};
    }

    @Test
    void MonotoneIncreasingDigitsTest() {
        for (int i = 0; i < testCases.input.length; i++) {
            assertEquals(testCases.expect[i], m.monotoneIncreasingDigits(testCases.input[i]));
        }
    }
}
