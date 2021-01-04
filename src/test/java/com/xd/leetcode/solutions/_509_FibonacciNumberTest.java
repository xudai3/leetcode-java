package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _509_FibonacciNumberTest {
    _509_FibonacciNumber f;
    int[] input;
    int[] expect;

    _509_FibonacciNumberTest() {
        f = new _509_FibonacciNumber();
        input = new int[]{0, 1, 2, 3, 4, 5};
        expect = new int[]{0, 1, 1, 2, 3, 5};
    }

    @Test
    void fib() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], f.fib(input[i]));
        }
    }

    @Test
    void fibRecursion() {
        for (int i = 0; i < input.length; i++) {
            assertEquals(expect[i], f.fibRecursion(input[i]));
        }
    }
}