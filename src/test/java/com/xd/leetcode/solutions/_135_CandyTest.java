package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _135_CandyTest {
    _135_Candy c;
    int[][] input;
    int[] expect;

    public _135_CandyTest() {
        c = new _135_Candy();
        input = new int[][]{{1,0,2},{1,2,2},{1,2,87,87,87,2,1},{1,3,2,2,1}};
        expect = new int[]{5,4,13,7};
//        input = new int[][]{{1,3,2,2,1}};
//        expect = new int[]{7};
    }

    @Test
    void candy() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], c.candy(input[i]));
        }
    }
}