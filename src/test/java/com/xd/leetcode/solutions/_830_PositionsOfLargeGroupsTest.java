package com.xd.leetcode.solutions;

import com.xd.leetcode.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class _830_PositionsOfLargeGroupsTest {
    _830_PositionsOfLargeGroups p;
    Utils u;
    String[] input;
    List<List<List<Integer>>> expect;

    _830_PositionsOfLargeGroupsTest() {
        p = new _830_PositionsOfLargeGroups();
        u = new Utils();
        input = new String[]{"abbxxxxzzy","abc","abcdddeeeeaabbbcd","aba"};
        expect = new ArrayList<>();
        List<List<Integer>> exp1 = new ArrayList<>();
        exp1.add(new ArrayList<>(Arrays.asList(3,6)));
        expect.add(exp1);
        List<List<Integer>> exp2 = new ArrayList<>();
        expect.add(exp2);
        List<List<Integer>> exp3 = new ArrayList<>();
        exp3.add(new ArrayList<>(Arrays.asList(3,5)));
        exp3.add(new ArrayList<>(Arrays.asList(6,9)));
        exp3.add(new ArrayList<>(Arrays.asList(12,14)));
        expect.add(exp3);
        List<List<Integer>> exp4 = new ArrayList<>();
        expect.add(exp4);
    }

    @Test
    void largeGroupPositions() {
        for (int i = 0; i < input.length; i++) {
            assertTrue(u.twoDArrayListEquals(expect.get(i), p.largeGroupPositions(input[i])));
        }
    }
}