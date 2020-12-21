package com.xd.leetcode.solutions;

import java.util.LinkedList;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 *
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 */

public class _316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        // 存储26个小写字母出现次数的哈希映射
        int[] cnt = new int[26];
        // 存储26个小写字母是否在单调栈中的哈希映射
        boolean[] exists = new boolean[26];
        // LinkedList模拟单调栈
        LinkedList<Character> stack = new LinkedList<>();
        // 记录每个字母出现次数
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            // 如果在栈中没有出现过
            if (!exists[cur-'a']) {
                // 如果栈不为空 && 栈顶元素字典序靠后 && 之后还会出现 就进行出栈操作
                while (!stack.isEmpty() && stack.getLast() > cur && cnt[stack.getLast()-'a'] > 0) {
                    exists[stack.getLast()-'a'] = false;
                    stack.removeLast();
                }
                // 否则直接压栈
                stack.add(cur);
                exists[cur-'a'] = true;
            }
            // 遍历过的字符次数-1
            cnt[cur-'a']--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
