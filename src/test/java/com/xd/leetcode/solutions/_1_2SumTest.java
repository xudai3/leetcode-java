package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _1_2SumTest {
    @Test
    void twoSum() {
        _1_2Sum ts = new _1_2Sum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] out = {0,1};
        assertArrayEquals(out, ts.twoSum(nums, target));
    }

}