package com.xd.leetcode.solutions;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:
 输入: ["flower","flow","flight"]
 输出: "fl"

 示例 2:
 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。

 说明:
 所有输入只包含小写字母 a-z

 */

public class _14_LongestCommonPrefix {
    /**
     * 纵向比较法
     * 从头开始依次比较每个字符串位置的字符是否都相同
     *
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        int count = strs[0].length();
        for (int i = 0; i < count; i++) {
            char pre = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != pre) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
    /**
     * 字典树
     */
    /**
     * 横向比较
     * 从字符串数组头开始依次两两寻找公共前缀
     */
}
