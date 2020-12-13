package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _69_SqrtXTest {
    class TestCases {
        int[] input;
        int[] output;
    }
    TestCases testCases;
    public _69_SqrtXTest() {
        testCases = new TestCases();
        testCases.input = new int[]{0,1,2,3,4,5,6,7,8,9,15,16,2147395599};
        testCases.output = new int[]{0,1,1,1,2,2,2,2,2,3,3,4,46339};
//        testCases.input = new int[]{2147395599};
//        testCases.output = new int[]{46339};
    }

    @Test
    void SqrtXTest() {
        _69_Sqrtx s = new _69_Sqrtx();
        for (int i = 0; i < testCases.input.length; i++) {
            assertEquals(testCases.output[i], s.mySqrt(testCases.input[i]), String.format("index %d failed",i+1));
        }
    }
}
