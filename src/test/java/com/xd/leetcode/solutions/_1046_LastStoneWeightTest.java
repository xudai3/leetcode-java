package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _1046_LastStoneWeightTest {
    _1046_LastStoneWeight l;
    int[][] input;
    int[] expect;

    public _1046_LastStoneWeightTest() {
        l = new _1046_LastStoneWeight();
        input = new int[][]{{},{6},{2,7,4,1,8,1},{2,4,1,6,10,2,1,7,9},{10,5,4,10,3,1,7,8}};
        expect = new int[]{0,6,1,0,0};
    }

    @Test
    void lastStoneWeight() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], l.lastStoneWeight(input[i]));
        }
    }

    @Test
    void lastStoneWeightWithMaxHeap() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], l.lastStoneWeightWithMaxHeap(input[i]));
        }
    }
}
