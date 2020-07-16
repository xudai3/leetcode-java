package com.xd.leetcode.solutions;

import java.util.HashMap;
import java.util.Stack;

public class _20_ValidParentheses {
    private HashMap<Character, Character> parenthesesMap = new HashMap<>();

    public _20_ValidParentheses() {
        parenthesesMap.put(')', '(');
        parenthesesMap.put(']', '[');
        parenthesesMap.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (parenthesesMap.containsKey(target)) {
                char top = stack.empty() ? '#' : stack.pop();
                if (top != parenthesesMap.get(target)) {
                    return false;
                }
            } else {
                stack.push(target);
            }
        }
        return stack.isEmpty();
    }
}
