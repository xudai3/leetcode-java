package com.xd.leetcode.offer;

import com.xd.leetcode.solutions.ListNode;
import com.xd.leetcode.utils.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _6_ReversePrintTest {
    _6_ReversePrint r;
    Utils u;
    int[] input;
    int[] expect;

    _6_ReversePrintTest() {
        r = new _6_ReversePrint();
        u = new Utils();
        input = new int[]{1,3,2};
        expect = new int[]{2,3,1};
    }

    @Test
    void reversePrint() {
        ListNode head = u.buildSinglyLinkedList(input);
        assertArrayEquals(expect, r.reversePrint(head));
    }

    @Test
    void reversePrint2() {
        ListNode head = u.buildSinglyLinkedList(input);
        assertArrayEquals(expect, r.reversePrint2(head));
    }

    @Test
    void reversePrint3() {
        ListNode head = u.buildSinglyLinkedList(input);
        assertArrayEquals(expect, r.reversePrint3(head));
    }
}