package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

public class _228_SummaryRangesTest {
    _228_SummaryRanges s;
    int[][] input;
    _228_SummaryRangesTest() {
        s = new _228_SummaryRanges();
        input = new int[][]{{0,1,2,4,5,7}, {0,2,3,4,6,8,9}, {}, {-1}, {0}};
    }

    @Test
    void summaryRanges() {
        for (int i = 0; i < input.length; i++) {
            System.out.println(s.summaryRanges(input[i]).toString());
        }
    }
}
