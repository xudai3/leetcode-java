package com.xd.leetcode.offer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _5_ReplaceSpaceTest {
    _5_ReplaceSpace r;
    String input;
    String expect;

    _5_ReplaceSpaceTest() {
        r = new _5_ReplaceSpace();
        input = "We are happy.";
        expect = "We%20are%20happy.";
    }

    @Test
    void replaceSpace() {
        assertEquals(r.replaceSpace(input), expect);
    }
}