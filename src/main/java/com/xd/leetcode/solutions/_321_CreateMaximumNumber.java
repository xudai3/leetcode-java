package com.xd.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<List<Integer>> sequences = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 遍历i+j=k
        for (int i = 0; i <= len1; i++) {
            int j = k - i;
            if (j > len2 || i > k) {
                continue;
            }
            int[] subNums1 = getMaxSubSequence(nums1, i);
            int[] subNums2 = getMaxSubSequence(nums2, j);
            int[] subMaxNums = mergeSubSequence(subNums1, subNums2);
            sequences.add(Arrays.stream(subMaxNums).boxed().collect(Collectors.toList()));
        }
        return getMaxSequence(sequences);
    }
    public int[] getMaxSubSequence(int[] nums, int n) {
        LinkedList<Integer> stack = new LinkedList<>();
        int len = nums.length;
        int removed = 0;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && stack.getLast() < num && removed < len-n) {
                stack.removeLast();
                removed++;
            }
            stack.add(num);
        }
        int[] maxSequence = new int[n];
        for (int i = 0; i < n; i++) {
            maxSequence[i] = stack.removeFirst();
        }
        return maxSequence;
    }
    public int[] mergeSubSequence(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] newArr = new int[len1 + len2];
        for (int idx = 0; idx < len1+len2; idx++) {
            // 合并的时候每次取数组前面最大的那个数字，如果相等的话则需要继续向后比较
            if (compareArr(nums1, i, nums2, j) > 0) {
                newArr[idx] = nums1[i++];
            } else {
                newArr[idx] = nums2[j++];
            }
        }
        return newArr;
    }
    public int compareArr(int[] nums1, int idx1, int[] nums2, int idx2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
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
    public int compareStr(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 != len2) {
            return len1 - len2;
        }
        for (int i = 0; i < len1; i++) {
            int diff = str1.charAt(i) - str2.charAt(i);
            if (diff != 0) {
                return diff;
            }
        }
        return 0;
    }
    public int[] getMaxSequence(List<List<Integer>> sequences) {
        String max = "";
        int idx = 0;
        for (int i = 0; i < sequences.size(); i++) {
            String numStr = "";
            List<Integer> sequence = sequences.get(i);
            int len = sequence.size();
            for (int j = 0; j < len; j++) {
                numStr += sequence.get(j);
            }
            // 有的case已经超过了long的范围，所以需要自己进行比较，这里使用转换成字符串再比较的方法
            if (compareStr(numStr, max) > 0) {
                max = numStr;
                idx = i;
            }
        }
        return sequences.get(idx).stream().mapToInt(i -> i).toArray();
    }
}
