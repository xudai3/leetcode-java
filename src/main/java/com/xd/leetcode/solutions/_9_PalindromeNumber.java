package com.xd.leetcode.solutions;

import com.sun.org.apache.regexp.internal.RE;

/**
 9. 回文数

 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

 示例 1:

 输入: 121
 输出: true
 示例 2:

 输入: -121
 输出: false
 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 示例 3:

 输入: 10
 输出: false
 解释: 从右向左读, 为 01 。因此它不是一个回文数。

 */

public class _9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        int divisor = 10;
        boolean isNotCritical = x < 0 || (x % divisor == 0 && x != 0);
        if (isNotCritical){
            return false;
        }
        int revertNum = 0;
        while (revertNum < x) {
            revertNum = revertNum * 10 + x % divisor;
            x /= divisor;
        }
        return revertNum == x || x == revertNum/10;
    }
}
