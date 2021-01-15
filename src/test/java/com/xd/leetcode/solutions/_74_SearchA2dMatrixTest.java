package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _74_SearchA2dMatrixTest {
    _74_SearchA2dMatrix s;
    int[][] input;
    int[] target;
    boolean[] expect;

    _74_SearchA2dMatrixTest() {
        s = new _74_SearchA2dMatrix();
        input = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        target = new int[]{0, 61, 12, 23, 7, 60};
        expect = new boolean[]{false, false, false, true, true, true};
    }

    @Test
    void searchMatrix() {
        for (int i = 0; i < target.length; i++) {
            assertEquals(expect[i], s.searchMatrix(input, target[i]));
        }
    }

    @Test
    void searchMatrix2() {
        for (int i = 0; i < target.length; i++) {
            assertEquals(expect[i], s.searchMatrix2(input, target[i]));
        }
    }
}