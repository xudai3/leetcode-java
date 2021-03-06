package com.xd.leetcode.solutions;

import java.util.Arrays;
import java.util.Comparator;

/**
 *给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 */
public class _435_NonOverlappingIntervals {
    /**
     * 先将所有的区间按起点从小到大排序
     * 先取第一段终点和第二段起点比较是否重叠，如果有重叠继续以更小的终点为基准比较下去，直到找到下一个没有重叠的区间
     * 再以这个区间作为基准继续往下进行比较
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals2(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) {
            return 0;
        }
        // 速度 写法1 > 写法2 >= 写法3
        // 排序写法1
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
        // 排序写法2
//        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 排序写法3
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int cnt = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < prevEnd) {
                prevEnd = Math.min(prevEnd, intervals[i][1]);
                cnt++;
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return cnt;
    }
    /**
     * 先将所有的区间按终点从小到大排序
     * 先取第一段终点和第二段起点比较是否重叠
     * 如果有重叠继续以第一段终点(因为排序后已经是最小，更短的区间可以保留后面更多的不重叠区间)为基准比较下去
     * 直到找到下一个没有重叠的区间
     * 再以这个区间作为基准继续往下进行比较
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int prevEnd = intervals[0][1];
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < prevEnd) {
                cnt++;
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return cnt;
    }
}
