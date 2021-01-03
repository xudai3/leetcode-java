package com.xd.leetcode.solutions;

import com.xd.leetcode.utils.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _86_PartitionListTest {
    _86_PartitionList p;
    Utils u;
    int[][] nodeArr;
    int[] valArr;
    int[][] expectArr;

    _86_PartitionListTest() {
        p = new _86_PartitionList();
        u = new Utils();
        nodeArr = new int[][]{{1, 4, 3, 2, 5, 2}, {2, 1}, {3, 1, 2}};
        valArr = new int[]{3, 2, 3};
        expectArr = new int[][]{{1, 2, 2, 4, 3, 5}, {1, 2}, {1, 2, 3}};
//        nodeArr = new int[][]{{3, 1, 2}};
//        valArr = new int[]{3};
//        expectArr = new int[][]{{1, 2, 3}};
    }

    @Test
    void partitionTwoPointer() {
        for (int i = 0; i < nodeArr.length; i++) {
            ListNode h1 = u.buildSinglyLinkedList(nodeArr[i]);
            ListNode h2 = u.buildSinglyLinkedList(expectArr[i]);
            h1 = p.partitionTwoPointer(h1, valArr[i]);
            assertEquals(true, u.linkedListEquals(h1, h2));
        }
    }

    @Test
    void partitionTwoLinkedList() {
        for (int i = 0; i < nodeArr.length; i++) {
            ListNode h1 = u.buildSinglyLinkedList(nodeArr[i]);
            ListNode h2 = u.buildSinglyLinkedList(expectArr[i]);
            h1 = p.partitionTwoLinkedList(h1, valArr[i]);
            assertEquals(true, u.linkedListEquals(h1, h2));
        }
    }
}
