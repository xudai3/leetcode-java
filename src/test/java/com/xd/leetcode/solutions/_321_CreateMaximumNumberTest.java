package com.xd.leetcode.solutions;

import com.xd.leetcode.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _321_CreateMaximumNumberTest {
    _321_CreateMaximumNumber c;
    Utils u;
    int[][] nums1;
    int[][] nums2;
    int[] k;
    String[] expect;
    _321_CreateMaximumNumberTest() {
        c = new _321_CreateMaximumNumber();
        u = new Utils();
        nums1 = new int[][]{{3,4,6,5}, {6,7}, {3,9}, {9,1,2,5,8,3}, {2,5,6,4,4,0}, {8,5,9,5,1,6,9}};
        nums2 = new int[][]{{9,1,2,5,8,3}, {6,0,4}, {8,9}, {3,4,6,5}, {7,3,8,0,6,5,7,6,2}, {2,6,4,3,8,4,1,0,7,2,9,2,8}};
        k = new int[]{5, 5, 3, 5, 15, 20};
        expect = new String[]{"98653", "67604", "989", "98653", "738256440657620", "85952643841691072928"};
    }

    @Test
    void maxNumber() {
        for (int i = 0; i < nums1.length; i++) {
            int[] output = c.maxNumber(nums1[i], nums2[i], k[i]);
            assertEquals(u.intArrayToString(output), expect[i]);
        }
    }

    @Test
    void getMaxSequence() {
        int[] input = new int[]{5, 4, 8, 3};
        int[] output = c.getMaxSubSequence(input, 3);
        System.out.println(Arrays.toString(output));
    }

    @Test
    void mergeSubSequence() {
        int[] nums1 = new int[]{6};
        int[] nums2 = new int[]{9, 5, 8, 3};
        int[] output = c.mergeSubSequence(nums1, nums2);
        System.out.println(Arrays.toString(output));
    }
}