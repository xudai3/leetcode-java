package com.xd.leetcode.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {
    Utils u;

    public UtilsTest() {
        u = new Utils();
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
}