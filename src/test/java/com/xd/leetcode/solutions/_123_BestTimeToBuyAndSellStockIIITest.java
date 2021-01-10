package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _123_BestTimeToBuyAndSellStockIIITest {
    _123_BestTimeToBuyAndSellStockIII b;
    int[][] input;
    int[] expect;

    _123_BestTimeToBuyAndSellStockIIITest() {
        b = new _123_BestTimeToBuyAndSellStockIII();
        input = new int[][]{{3,3,5,0,0,3,1,4}, {1,2,3,4,5}, {7,6,4,3,1}, {1}};
        expect = new int[]{6, 4, 0, 0};
    }

    @Test
    void maxProfit() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], b.maxProfit(input[i]));
        }
    }
}
