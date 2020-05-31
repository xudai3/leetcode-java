package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _15_3SumTest {
    @Test
    void threeSum() {
        int[] input = new int[]{-1,0,1,2,-1,-4};
        _15_3Sum ts = new _15_3Sum();
        System.out.println(ts.threeSum(input));
    }

    @Test
    void threeSum2() {
        int[] input = new int[]{-1,0,1,2,-1,-4};
        _15_3Sum ts = new _15_3Sum();
        System.out.println(ts.threeSum2(input));
    }

}