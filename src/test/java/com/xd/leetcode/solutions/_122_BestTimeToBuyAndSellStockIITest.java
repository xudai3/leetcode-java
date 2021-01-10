package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _122_BestTimeToBuyAndSellStockIITest {
    _122_BestTimeToBuyAndSellStockII b;
    int[][] input;
    int[] expect;

    _122_BestTimeToBuyAndSellStockIITest() {
        b = new _122_BestTimeToBuyAndSellStockII();
        input = new int[][]{{7,1,5,3,6,4}, {1,2,3,4,5}, {7,6,4,3,1}};
        expect = new int[]{7, 4, 0};
    }

    @Test
    void maxProfit() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], b.maxProfit(input[i]));
        }
    }

    @Test
    void maxProfit2() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], b.maxProfit2(input[i]));
        }
    }

    @Test
    void maxProfit3() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], b.maxProfit3(input[i]));
        }
    }
}
