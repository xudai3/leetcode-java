package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _435_NonOverlappingIntervalsTest {
    _435_NonOverlappingIntervals n;
    int[][][] input;
    int[] expect;
    _435_NonOverlappingIntervalsTest() {
        n = new _435_NonOverlappingIntervals();
        input = new int[][][]{{{1,2},{2,3},{3,4},{1,3}}, {{1,2},{1,2},{1,2}}, {{1,2},{2,3}}, {{1,2},{2,3},{3,4},{-100,-2},{5,7}}};
        expect = new int[]{1, 2, 0, 0};
    }

    @Test
    void eraseOverlapIntervals() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], n.eraseOverlapIntervals(input[i]));
        }
    }

    @Test
    void eraseOverlapIntervals2() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], n.eraseOverlapIntervals2(input[i]));
        }
    }

    @Test
    void testLambda() {
        int[][] a = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        Arrays.sort(a, (a1, a2) -> a2[1] - a1[1]);
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d,%d\n", a[i][0], a[i][1]);
        }
    }
}