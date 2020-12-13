package com.xd.leetcode.solutions;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 */

public class _69_Sqrtx {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int ans = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            System.out.printf("low:%d mid:%d high:%d mid*mid:%d x:%d\n", low, mid, high, mid*mid, x);
            if (((long)mid * mid) <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
