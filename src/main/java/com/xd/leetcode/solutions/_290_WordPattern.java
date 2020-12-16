package com.xd.leetcode.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 *
 */

public class _290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] patterns = pattern.split("");
        String[] strs = s.split(" ");
        if (patterns.length != strs.length) {
            return false;
        }
        Map<String, String> patternMap = new HashMap<>();
        Map<String, String> strMap = new HashMap<>();
        System.out.println(Arrays.toString(patterns));
        System.out.println(Arrays.toString(strs));

        for (int i = 0; i < patterns.length; i++) {
            if (patternMap.containsKey(patterns[i])) {
                if (!patternMap.get(patterns[i]).equals(strs[i])) {
                    System.out.printf("pattern:%s, str:%s\n", patternMap.get(patterns[i]), strs[i]);
                    return false;
                }
            } else {
                patternMap.put(patterns[i], strs[i]);
                if (strMap.containsKey(strs[i])) {
                    if (!strMap.get(strs[i]).equals(patterns[i])) {
                        return false;
                    }
                } else {
                    strMap.put(strs[i], patterns[i]);
                }
            }
        }

        return true;
    }
}
