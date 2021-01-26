package com.xd.leetcode.offer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _3_FindRepeatNumberTest {
    _3_FindRepeatNumber f;
    int[][] nums;
    int[] expect;

    _3_FindRepeatNumberTest() {
        f = new _3_FindRepeatNumber();
        nums = new int[][]{{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {3, 1, 2, 3}, {2, 3, 1, 0, 2, 5, 3}};
        expect = new int[]{11, 3, 2};
    }

    @Test
    void findRepeatNumber() {
        for (int i = 0; i < nums.length; i++) {
            assertEquals(expect[i], f.findRepeatNumber(nums[i]));
        }
    }
}