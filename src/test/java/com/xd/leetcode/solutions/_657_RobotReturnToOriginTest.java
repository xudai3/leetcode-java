package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _657_RobotReturnToOriginTest {
    _657_RobotReturnToOrigin r;
    String[] input;
    boolean[] expect;

    _657_RobotReturnToOriginTest() {
        r = new _657_RobotReturnToOrigin();
        input = new String[]{"UD", "LL"};
        expect = new boolean[]{true, false};
    }

    @Test
    void judgeCircle() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], r.judgeCircle(input[i]));
        }
    }

    @Test
    void judgeCircle2() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], r.judgeCircle2(input[i]));
        }
    }
}