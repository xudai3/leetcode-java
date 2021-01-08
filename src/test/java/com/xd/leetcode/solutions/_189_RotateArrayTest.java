package com.xd.leetcode.solutions;

import com.xd.leetcode.utils.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class _189_RotateArrayTest {
    _189_RotateArray r;
    Utils u;
    int[][] input;
    int[] k;
    int[][] expect;
    public _189_RotateArrayTest() {
        r = new _189_RotateArray();
        u = new Utils();
        input = new int[][]{{1, 2, 3, 4, 5, 6, 7}, {-1, -100, 3, 99}};
        k = new int[]{3, 2};
        expect = new int[][]{{5, 6, 7, 1, 2, 3, 4}, {3, 99, -1, -100}};
    }

    @Test
    void rotate() {
        for (int i = 0; i < input.length; i++) {
            r.rotate(input[i], k[i]);
            assertTrue(u.intArrayEquals(input[i], expect[i]));
        }
    }

    @Test
    void rotate2() {
        for (int i = 0; i < input.length; i++) {
            r.rotate2(input[i], k[i]);
            assertTrue(u.intArrayEquals(input[i], expect[i]));
        }
    }
}
