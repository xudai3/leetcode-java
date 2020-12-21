package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _747_MinCostClimbingStairsTest {

    _747_MinCostClimbingStairs m;
    int[][] input;
    int[] expect;

    public _747_MinCostClimbingStairsTest() {
        m = new _747_MinCostClimbingStairs();
        input = new int[][]{{10, 15, 20}, {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, {0, 1, 2, 2}};
        expect = new int[]{15, 6, 2};
    }
    @Test
    void minCostClimbingStairs() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], m.minCostClimbingStairs(input[i]));
        }
    }
}