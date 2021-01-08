package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _547_NumberOfProvincesTest {
    _547_NumberOfProvinces n;
    int[][][] input;
    int[] expect;
    _547_NumberOfProvincesTest() {
        n = new _547_NumberOfProvinces();
        input = new int[][][]{{{1,1,0},{1,1,0},{0,0,1}}, {{1,0,0},{0,1,0},{0,0,1}}};
        expect = new int[]{2,3};
    }

    @Test
    void findCircleNum() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], n.findCircleNum(input[i]));
        }
    }
}