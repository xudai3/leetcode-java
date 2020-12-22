package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _387_FirstUniqueCharacterInAStringTest {
    _387_FirstUniqueCharacterInAString f;
    String[] input;
    int[] expect;

    public _387_FirstUniqueCharacterInAStringTest() {
        f = new _387_FirstUniqueCharacterInAString();
        input = new String[]{"leetcode", "loveleetcode"};
        expect = new int[]{0, 2};
    }

    @Test
    void firstUniqChar() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], f.firstUniqChar(input[i]));
        }
    }
}
