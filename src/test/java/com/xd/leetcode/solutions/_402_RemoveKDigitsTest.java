package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _402_RemoveKDigitsTest {
    _402_RemoveKDigits r;
    String[] input;
    int[] k;
    String[] expect;
    public _402_RemoveKDigitsTest() {
        r = new _402_RemoveKDigits();
        input = new String[]{"1432219","10200","10","112","1234567890"};
        k = new int[]{3,1,2,1,9};
        expect = new String[]{"1219","200","0","11","0"};
    }
    @Test
    void removeKdigits() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], r.removeKdigits(input[i], k[i]));
        }
    }
}
