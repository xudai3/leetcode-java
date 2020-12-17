package com.xd.leetcode.solutions;

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
    /**
     *
     * 单map保存pattern-string的映射关系
     * 遍历pattern每个字母,如果pattern不存在并且string也不存在，就存入map
     * 如果pattern存在，就判断这个pattern对应的string是否相等
     *
     */
    public boolean wordPatternOneMap(String pattern, String s) {
        String[] tmp = new String[26];
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            int idx = pattern.charAt(i) - 'a';
            if (tmp[idx] == null && notInStrArr(tmp, strs[i])) {
                tmp[idx] = strs[i];
            } else {
                if (!strs[i].equals(tmp[idx])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean notInStrArr(String[] strArr, String target) {
        for (int i = 0; i < strArr.length; i++) {
            if (target.equals(strArr[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * 双map map1保存pattern-string和map2保存string-pattern的映射关系
     * 遍历pattern每个字母,如果pattern存在于map1中，就判断这个pattern对应的string是否相等
     * 如果pattern不存在,就用map2判断string是否存在于map2中，如果存在则返回false，否则map1和map2分别存入对应关系
     */
    public boolean wordPatternTwoMap(String pattern, String s) {
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        Map<Character, String> patternMap = new HashMap<>(pattern.length());
        Map<String, Character> strMap = new HashMap<>(strs.length);

        for (int i = 0; i < pattern.length(); i++) {
            if (patternMap.containsKey(pattern.charAt(i))) {
                if (!patternMap.get(pattern.charAt(i)).equals(strs[i])) {
                    return false;
                }
            } else {
                if (strMap.containsKey(strs[i])) {
                    return false;
                }
                strMap.put(strs[i], pattern.charAt(i));
                patternMap.put(pattern.charAt(i), strs[i]);
            }
        }

        return true;
    }
}
