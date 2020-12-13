package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _217_ContainsDuplicateTest {
    class TestCases {
        int[] nums;
        boolean expect;
    }
    ArrayList<TestCases> testCases;
    public _217_ContainsDuplicateTest() {
        testCases = new ArrayList<>();
        TestCases tc1 = new TestCases();
        tc1.nums = new int[]{1,2,3,1};
        tc1.expect = true;
        testCases.add(tc1);
        TestCases tc2 = new TestCases();
        tc2.nums = new int[]{1,2,3,4};
        tc2.expect = false;
        testCases.add(tc2);
        TestCases tc3 = new TestCases();
        tc3.nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        tc3.expect = true;
        testCases.add(tc3);
    }

    @Test
    void ContainsDuplicateTest() {
        _217_ContainsDuplicate c = new _217_ContainsDuplicate();
        for (TestCases tc : testCases) {
            assertEquals(tc.expect, c.containsDuplicate(tc.nums), String.format("test:%s failed", Arrays.toString(tc.nums)));
        }
    }
}
