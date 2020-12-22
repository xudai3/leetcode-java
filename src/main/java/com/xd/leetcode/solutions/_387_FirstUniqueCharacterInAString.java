package com.xd.leetcode.solutions;

public class _387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int n = s.length();
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        int[] hash = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            hash[c-'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (hash[chars[i]-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
