package com.xd.leetcode.solutions;

public class _402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        // "10" 2
        if (n <= k) {
            return 0+"";
        }
        // "0" 0
        if (k == 0) {
            return num;
        }
        StringBuilder sb = new StringBuilder();
        int removed = 0;
        // 要移除k个数字，则剩下n-k个数字，从左到右开始每位都选最小的数字，最后的数字就会是最小的
        for (int cnt = 0,i = 0; cnt < n-k; cnt++,i++) {
            char min = num.charAt(i);
            // 从左到右遍历选最小数字，每跳过一个数字相当于要移除一个数字，要注意不能移除大于k个数字
            for (int j = i; j <= i+k-removed; j++) {
                if (num.charAt(j) < min) {
                    min = num.charAt(j);
                    removed += j - i;
                    i = j;
                }
            }
            // 去掉前导"0"，并且如果字符串就剩"0"的时候要返回"0"
            if (sb.length() == 0) {
                if (min == '0' && cnt != n-k-1) {
                    continue;
                }
            }
            sb.append(min);
        }
        return sb.toString();
    }
}
