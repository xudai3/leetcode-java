package com.xd.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class _229_MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>(2);
        if (nums == null || nums.length == 0) {
            return result;
        }
        int candidateNum1 = 0;
        int candidateNum2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        int majorityMax = 3;
        for (int num : nums) {
            if (num == candidateNum1) {
                cnt1++;
            } else if (num == candidateNum2) {
                cnt2++;
            } else {
                if (cnt1 == 0) {
                    candidateNum1 = num;
                    cnt1++;
                } else if (cnt2 == 0) {
                    candidateNum2 = num;
                    cnt2++;
                } else {
                    cnt1--;
                    cnt2--;
                }
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == candidateNum1) {
                cnt1++;
            } else if (num == candidateNum2) {
                cnt2++;
            }
        }
        int n = nums.length;
        if (cnt1 > n / majorityMax) {
            result.add(candidateNum1);
        }
        if (cnt2 > n / majorityMax) {
            result.add(candidateNum2);
        }
        return result;
    }
}
