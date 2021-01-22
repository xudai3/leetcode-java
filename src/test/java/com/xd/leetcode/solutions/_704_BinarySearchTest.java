package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _704_BinarySearchTest {
    _704_BinarySearch b;
    int[] input;
    int[] target;
    int[] expect;

    _704_BinarySearchTest() {
        b = new _704_BinarySearch();
        input = new int[]{-1,0,3,5,9,12};
        target = new int[]{9,2};
        expect = new int[]{4,-1};
//        input = new int[]{5};
//        target = new int[]{5};
//        expect = new int[]{0};
    }

    @Test
    void search() {
        for (int i = 0; i < target.length; i++) {
            assertEquals(expect[i], b.search(input, target[i]));
        }
    }

    @Test
    void search2() {
        for (int i = 0; i < target.length; i++) {
            assertEquals(expect[i], b.search2(input, target[i]));
        }
    }

    @Test
    void search3() {
        for (int i = 0; i < target.length; i++) {
            assertEquals(expect[i], b.search3(input, target[i]));
        }
    }
}