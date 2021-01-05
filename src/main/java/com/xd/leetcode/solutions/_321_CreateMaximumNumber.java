package com.xd.leetcode.solutions;

/**
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
 * 示例 1:
 *
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 *
 * 示例 2:
 *
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 *
 * 示例 3:
 *
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 *
 */

public class _321_CreateMaximumNumber {
    /**
     * 分别从nums1和nums2取i和j个数的最大子序列，再组合成一个最大的数
     * 遍历所有有i+j=k的情况，再从这些情况组成的所有数中找到最大的那一个
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] maxSequence = new int[k];
        // 如果len2=3而k=5，则第一个数组至少要选2个数出来
        int start = Math.max(0, k-len2);
        // 如果len1=5而k=3，则第一个数组最多也只能选3个数
        int end = Math.min(k, len1);
        for (int i = start; i <= end; i++) {
            int[] subNums1 = maxSubsequence(nums1, i);
            int[] subNums2 = maxSubsequence(nums2, k-i);
            int[] subMaxNums = merge(subNums1, subNums2);
            // 用maxSequence存储每次比较的最大值，之前是用二维数组存储再找最大，节约了一些时间
            if (compare(subMaxNums, 0, maxSequence, 0) > 0) {
                System.arraycopy(subMaxNums, 0, maxSequence, 0, k);
            }
        }
        return maxSequence;
    }
    // 直接使用数组模拟栈而不用LinkedList来模拟栈可以直接返回结果，不用从LinkedList里取出来放到数组里，节约了一些时间
    public int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        // 栈顶
        int top = -1;
        // 栈剩余空间
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                // top = k - 1的时候就已经是没有剩余空间了，remain--跳出循环
                remain--;
            }
        }
        return stack;
    }
    public int[] merge(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0) {
            return nums2;
        }
        if (len2 == 0) {
            return nums1;
        }
        int mergeLen = len1 + len2;
        int[] newArr = new int[mergeLen];
        int i = 0;
        int j = 0;
        for (int idx = 0; idx < mergeLen; idx++) {
            // 合并的时候每次取数组前面最大的那个数字，如果相等的话则需要继续向后比较
            if (compare(nums1, i, nums2, j) > 0) {
                newArr[idx] = nums1[i++];
            } else {
                newArr[idx] = nums2[j++];
            }
        }
        return newArr;
    }
    public int compare(int[] nums1, int idx1, int[] nums2, int idx2) {
        int len1 = nums1.length, len2 = nums2.length;
        while (idx1 < len1 && idx2 < len2) {
            int diff = nums1[idx1] - nums2[idx2];
            if (diff != 0) {
                return diff;
            }
            idx1++;
            idx2++;
        }
        return (len1 - idx1) - (len2 - idx2);
    }
}
