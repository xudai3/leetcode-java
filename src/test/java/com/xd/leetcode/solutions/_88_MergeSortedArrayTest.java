package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class _88_MergeSortedArrayTest {
    _88_MergeSortedArray msa;
    int[][] nums1;
    int[] m;
    int[][] nums2;
    int[] n;
    int[][] expect;

    _88_MergeSortedArrayTest() {
        msa = new _88_MergeSortedArray();
        nums1 = new int[][]{{1,2,3,0,0,0}, {1}, {1,2,3,0,0,0}};
        m = new int[]{3, 1, 3};
        nums2 = new int[][]{{2,5,6}, {}, {4,5,6}};
        n = new int[]{3, 0, 3};
        expect = new int[][]{{1,2,2,3,5,6}, {1}, {1,2,3,4,5,6}};
    }

    @Test
    void merge() {
        for (int i = 0; i < nums1.length; i++) {
            msa.merge(nums1[i], m[i], nums2[i], n[i]);
            assertArrayEquals(expect[i], nums1[i]);
        }
    }

    @Test
    void merge2() {
        for (int i = 0; i < nums1.length; i++) {
            msa.merge2(nums1[i], m[i], nums2[i], n[i]);
            assertArrayEquals(expect[i], nums1[i]);
        }
    }

    @Test
    void merge3() {
        for (int i = 0; i < nums1.length; i++) {
            msa.merge3(nums1[i], m[i], nums2[i], n[i]);
            assertArrayEquals(expect[i], nums1[i]);
        }
    }
}