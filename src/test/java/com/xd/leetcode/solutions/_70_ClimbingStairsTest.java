package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _70_ClimbingStairsTest {

    _70_ClimbingStairs c;
    int[] input;
    int[] expect;

    public _70_ClimbingStairsTest() {
        c = new _70_ClimbingStairs();
        input = new int[]{2,3};
        expect = new int[]{2,3};
    }

    @Test
    void climbStairs() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], c.climbStairs(input[i]));
        }
    }
}