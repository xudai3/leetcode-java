package com.xd.leetcode.solutions;

public class _169_MajorityElement {
    public int majorityElement2(int[] nums) {
        int candidate = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num == candidate) {
                cnt++;
            } else {
                if (cnt == 0) {
                    candidate = num;
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }
        return candidate;
    }
}
