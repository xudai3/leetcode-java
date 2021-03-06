package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;


public class _9_PalindromeNumberTest {

    private HashMap<Integer, Boolean> testCases = new HashMap<>();
    public _9_PalindromeNumberTest() {
        this.testCases.put(121,true);
        this.testCases.put(-121,false);
        this.testCases.put(10,false);
    }

    @Test
    public void isPalindromeTest() {
        _9_PalindromeNumber pn = new _9_PalindromeNumber();
        for (Map.Entry<Integer, Boolean> entry: this.testCases.entrySet())
            assertEquals(pn.isPalindrome(entry.getKey()), entry.getValue());
    }

    @Test
    public void isPalindrome2Test() {
        _9_PalindromeNumber pn = new _9_PalindromeNumber();
        for (Map.Entry<Integer, Boolean> entry: this.testCases.entrySet())
            assertEquals(pn.isPalindrome2(entry.getKey()), entry.getValue());
    }
}
