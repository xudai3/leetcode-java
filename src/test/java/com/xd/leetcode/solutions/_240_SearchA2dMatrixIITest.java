package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _240_SearchA2dMatrixIITest {
    _240_SearchA2dMatrixII s;
    int[][] input;
    int[] target;
    boolean[] expect;

    _240_SearchA2dMatrixIITest() {
        s = new _240_SearchA2dMatrixII();
        input = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        target = new int[]{0, 31, 20, 15, 18, 30};
        expect = new boolean[]{false, false, false, true, true, true};
    }

    @Test
    void searchMatrix() {
        for (int i = 0; i < target.length; i++) {
            assertEquals(expect[i], s.searchMatrix(input, target[i]));
        }
    }
}