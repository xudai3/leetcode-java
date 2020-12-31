package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _455_AssignCookiesTest {
    _455_AssignCookies a;
    int[][] g;
    int[][] s;
    int[] expect;

    public _455_AssignCookiesTest() {
        a = new _455_AssignCookies();
        g = new int[][]{{1,2,3}, {1,2}};
        s = new int[][]{{1,1}, {1,2,3}};
        expect = new int[]{1, 2};
    }

    @Test
    void findContentChildren() {
        for (int i = 0; i < g.length; i++) {
            assertEquals(expect[i], a.findContentChildren(g[i], s[i]));
        }
    }

    @Test
    void findContentChildren2() {
        for (int i = 0; i < g.length; i++) {
            assertEquals(expect[i], a.findContentChildren2(g[i], s[i]));
        }
    }

    @Test
    void findContentChildren3() {
        for (int i = 0; i < g.length; i++) {
            assertEquals(expect[i], a.findContentChildren3(g[i], s[i]));
        }
    }
}