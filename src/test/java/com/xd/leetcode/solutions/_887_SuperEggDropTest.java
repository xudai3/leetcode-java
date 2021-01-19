package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _887_SuperEggDropTest {
    _887_SuperEggDrop s;
    int[] K;
    int[] N;
    int[] expect;

    _887_SuperEggDropTest() {
        s = new _887_SuperEggDrop();
        K = new int[]{1, 2, 3};
        N = new int[]{2, 6, 14};
        expect = new int[]{2, 3, 4};
    }

    @Test
    void superEggDrop() {
        for (int i = 0; i < K.length; i++) {
            assertEquals(expect[i], s.superEggDrop(K[i], N[i]));
        }
    }

    @Test
    void superEggDrop2() {
        for (int i = 0; i < K.length; i++) {
            assertEquals(expect[i], s.superEggDrop2(K[i], N[i]));
        }
    }

    @Test
    void superEggDrop3() {
        for (int i = 0; i < K.length; i++) {
            assertEquals(expect[i], s.superEggDrop3(K[i], N[i]));
        }
    }

    @Test
    void superEggDrop4() {
        for (int i = 0; i < K.length; i++) {
            assertEquals(expect[i], s.superEggDrop4(K[i], N[i]));
        }
    }

    @Test
    void superEggDrop5() {
        for (int i = 0; i < K.length; i++) {
            assertEquals(expect[i], s.superEggDrop5(K[i], N[i]));
        }
    }
}