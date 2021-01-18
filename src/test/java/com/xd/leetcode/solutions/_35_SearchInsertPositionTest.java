package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _35_SearchInsertPositionTest {
    _35_SearchInsertPosition s;
    int[] nums;
    int[] target;
    int[] expect;

    _35_SearchInsertPositionTest() {
        s = new _35_SearchInsertPosition();
        nums = new int[]{1,3,5,6};
        target = new int[]{5,2,7,0};
        expect = new int[]{2,1,4,0};
    }

    @Test
    void searchInsert() {
        for (int i = 0; i < nums.length; i++) {
            assertEquals(expect[i], s.searchInsert(nums, target[i]));
        }
    }
}