package com.xd.leetcode.offer;

import com.xd.leetcode.solutions.ListNode;

import java.util.LinkedList;

public class _6_ReversePrint {
    int[] res;
    int cnt = 0;
    int idx = 0;
    public int[] reversePrint3(ListNode head) {
        ListNode p = head;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        res = new int[cnt];
        p = head;
        while (p != null) {
            res[--cnt] = p.val;
            p = p.next;
        }
        return res;
    }
    public int[] reversePrint2(ListNode head) {
        recursive(head);
        return res;
    }
    public void recursive(ListNode head) {
        if (head == null) {
            res = new int[cnt];
            return;
        }
        cnt++;
        recursive(head.next);
        res[idx++] = head.val;
    }

    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            stack.addFirst(p.val);
            p = p.next;
        }
        res = new int[stack.size()];
        int i = 0;
        for (Integer num : stack) {
            res[i++] = num;
        }
        return res;
    }
}
