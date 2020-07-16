package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _20_ValidParenthesesTest {

    private HashMap<String, Boolean> testCases = new HashMap<>();

    public _20_ValidParenthesesTest() {
        this.testCases.put("()",true);
        this.testCases.put("(]",false);
        this.testCases.put("{()}",true);
    }

    @Test
    void TestIsValid() {
        _20_ValidParentheses vp = new _20_ValidParentheses();
        for (Map.Entry<String, Boolean> entry : this.testCases.entrySet()) {
            assertEquals(vp.isValid(entry.getKey()), entry.getValue());
        }
    }
}
