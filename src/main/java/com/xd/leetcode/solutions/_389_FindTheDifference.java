package com.xd.leetcode.solutions;

public class _389_FindTheDifference {
    public char findTheDifferenceHash(String s, String t) {
        int[] mapS = new int[26];
        int[] mapT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            mapS[s.charAt(i)-'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            mapT[t.charAt(i)-'a'] += 1;
        }
        for (int i = 0; i < mapS.length; i++) {
            if (mapS[i] != mapT[i]) {
                return (char)(i+'a');
            }
        }
        return 'a';
    }

    /**
     * a ^ 0 = a   a ^ a = a
     * a ^ b ^ a = (a ^ a) ^ b = b
     * @param s
     * @param t
     * @return
     */
    public char findTheDifferenceXOR(String s, String t) {
        char ans = t.charAt(t.length()-1);
        for (int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);
        }
        return ans;
    }
}
