package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _1046_LastStoneWeightTest {
    _1046_LastStoneWeight l;
    int[][] input;
    int[] expect;

    public _1046_LastStoneWeightTest() {
        l = new _1046_LastStoneWeight();
        input = new int[][]{{2,7,4,1,8,1}};
        expect = new int[]{1};
    }

    @Test
    void lastStoneWeight() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], l.lastStoneWeight(input[i]));
        }
    }
}
