package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _121_BestTimeToBuyAndSellStockTest {
    class TestCases {
        int[] input;
        int expect;
    }
    List<TestCases> testCases;
    _121_BestTimeToBuyAndSellStock b;
    public _121_BestTimeToBuyAndSellStockTest() {
        b = new _121_BestTimeToBuyAndSellStock();
        testCases = new ArrayList<>();
        TestCases tc1 = new TestCases();
        tc1.input = new int[]{7,1,5,3,6,4};
        tc1.expect = 5;
        testCases.add(tc1);
        TestCases tc2 = new TestCases();
        tc2.input = new int[]{7,6,4,3,1};
        tc2.expect = 0;
        testCases.add(tc2);
    }
    @Test
    void maxProfit() {
        for (TestCases tc : testCases) {
            assertEquals(tc.expect, b.maxProfit(tc.input));
        }
    }
    @Test
    void maxProfit2Pointer() {
        for (TestCases tc : testCases) {
            assertEquals(tc.expect, b.maxProfit2Pointer(tc.input));
        }
    }
}
