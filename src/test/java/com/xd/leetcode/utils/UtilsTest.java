package com.xd.leetcode.utils;

import com.xd.leetcode.solutions.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    Utils u;

    public UtilsTest() {
        u = new Utils();
    }

    @Test
    void buildSinglyLinkedList() {
        int[] arr = new int[]{1,4,3,2,5,2};
        ListNode head = u.buildSinglyLinkedList(arr);
        u.printLinkedList(head);
    }

    @Test
    void linkedListEquals() {
        int[] arr1 = new int[]{1,4,3,2,5,2};
        int[] arr2 = new int[]{1,4,3,2,5,2};
        int[] arr3 = new int[]{1,4,3,2,5,3};
        ListNode h1 = u.buildSinglyLinkedList(arr1);
        ListNode h2 = u.buildSinglyLinkedList(arr2);
        ListNode h3 = u.buildSinglyLinkedList(arr3);
        assertEquals(true, u.linkedListEquals(h1, h2));
        assertEquals(false, u.linkedListEquals(h1, h3));
    }

    @Test
    void buildTree() {
    }

    @Test
    void arrayListEquals() {
        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(Arrays.asList(1,2,3,4,5));
        list1.add(Arrays.asList(6,7,8,9,10));
        List<List<Integer>> list2 = new ArrayList<>();
        list2.add(Arrays.asList(1,2,3,4,5));
        list2.add(Arrays.asList(6,7,8,9,10));
        assertEquals(true,u.twoDArrayListEquals(list1, list2));
        List<List<Integer>> list3 = new ArrayList<>();
        list3.add(Arrays.asList(1,2,3,4,5));
        list3.add(Arrays.asList(6,7,8,9,10));
        List<List<Integer>> list4 = new ArrayList<>();
        list4.add(Arrays.asList(1,2,3,4,5));
        list4.add(Arrays.asList(6,7,8,9,0));
        assertEquals(false,u.twoDArrayListEquals(list3, list4));
    }

    @Test
    void intArrayEquals() {
        int[] arr1 = new int[]{1,4,3,2,5,2};
        int[] arr2 = new int[]{1,4,3,2,5,2};
        int[] arr3 = new int[]{1,4,3,2,5,3};
        assertTrue(u.intArrayEquals(arr1, arr2));
        assertFalse(u.intArrayEquals(arr1, arr3));
    }

    @Test
    void doubleArrayEquals() {
        double[] arr1 = new double[]{1.0, 2.0, -1.0};
        double[] arr2 = new double[]{1.0, 2.0, -1.0};
        double[] arr3 = new double[]{1.00, 2.0, -1.0};
        double[] arr4 = new double[]{1.75, 2.0, -1.0};
        assertTrue(u.doubleArrayEquals(arr1, arr2));
        assertTrue(u.doubleArrayEquals(arr1, arr3));
        assertFalse(u.doubleArrayEquals(arr1, arr4));
    }

    @Test
    void twoDStringArrayToList() {
        String[][] arr = new String[][]{{"a", "b"}, {"c", "d"}};
        List result = u.twoDStringArrayToList(arr);
        System.out.println(result.toString());
    }
}