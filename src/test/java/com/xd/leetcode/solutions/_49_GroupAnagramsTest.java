package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class _49_GroupAnagramsTest {
    class TestCases {
        String[] input;
        List<List<String>> expect;
    }

    _49_GroupAnagrams g;
    List<TestCases> testCases;

    _49_GroupAnagramsTest() {
        g = new _49_GroupAnagrams();
        testCases = new ArrayList<>();
//        TestCases tc1 = new TestCases();
//        tc1.input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        testCases.add(tc1);
        TestCases tc2 = new TestCases();
        tc2.input = new String[]{"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        testCases.add(tc2);
    }

    @Test
    void groupAnagrams() {
        for (TestCases tc : testCases) {
            List<List<String>> result = g.groupAnagrams(tc.input);
            System.out.println(result.toString());
        }
    }

    @Test
    void getHash() {
        for (TestCases tc : testCases) {
            for (String str : tc.input) {
                System.out.println(g.getHash(str));
            }
        }
    }
}