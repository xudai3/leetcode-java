package com.xd.leetcode.solutions;

import java.util.*;

/**
 *
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 */

public class _49_GroupAnagrams {

    /**
     *
     * "eat", "tea", "ate" 排序之后都是"aet"，将排序后的字符串作为hash key
     *
     */
    public List<List<String>> groupAnagramsSortHash(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String sortedStr = new String(strChars);
            checkHash(hash, str, sortedStr);
        }
        return new ArrayList<>(hash.values());
    }

    /**
     *
     * "eat", "tea", "ate" 对每个字母出现的次数进行计数，编码在一起成字符串"a1e1t1"，将该字符串作为hash key
     *
     */
    public List<List<String>> groupAnagramsCountHash(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            String key = getHashKey(str);
            checkHash(hash, str, key);
        }
        return new ArrayList<>(hash.values());
    }

    public void checkHash(Map<String, List<String>> hash, String str, String key) {
        if (hash.containsKey(key)) {
            List<String> val = hash.get(key);
            val.add(str);
        } else {
            List<String> val = new ArrayList<>();
            val.add(str);
            hash.put(key, val);
        }
    }

    public String getHashKey(String str) {
        int[] counter = new int[26];
        for (int i = 0; i < str.length(); i++) {
            counter[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                sb.append((char)(i+'a'));
                sb.append(counter[i]);
            }
        }
        return sb.toString();
    }
}
