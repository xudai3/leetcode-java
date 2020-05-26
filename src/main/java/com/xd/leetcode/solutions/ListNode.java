package com.xd.leetcode.solutions;

public class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
    ListNode(int val) {
        this.val = val;
        next = null;
    }
}
