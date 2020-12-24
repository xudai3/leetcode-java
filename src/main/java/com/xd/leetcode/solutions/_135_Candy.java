package com.xd.leetcode.solutions;

import java.util.Arrays;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 */

public class _135_Candy {
    /**
     * 左规则：当ratings[i]>ratings[i-1],candy[i]>candy[i-1]
     * 右规则：当ratings[i-1]>ratings[i],candy[i-1]>candy[i]
     * 遍历两遍，两个数组分别存储满足左右规则的最小糖果数量，取最大值就是同时满足左右规则的糖果数量
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        // 从左往右遍历判断左规则
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;
            }
        }
        int sum = left[n-1];
        // 从右往左遍历判断左规则
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                right[i] = right[i+1] + 1;
            }
            sum += Integer.max(left[i], right[i]);
        }
        return sum;
    }

    // 勉强能通过...600+ms，运行时间倒数7%...
    public int candy2(int[] ratings) {
        int n = ratings.length;
        if (n == 0) {
            return 0;
        }
        int[] candys = new int[n];
        candys[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candys[i] = candys[i-1] + 1;
            } else if (ratings[i] < ratings[i-1]){
                int j = i - 1;
                while (j >= 0 && ratings[j+1] < ratings[j]) {
                    if (candys[j+1] == 0) {
                        candys[j+1] = 1;
                    }
                    if (candys[j+1] == candys[j]) {
                        candys[j]++;
                    }
                    j--;
                }
            } else {
                candys[i] = 1;
            }
        }
        int sum = 0;
        for (int candy : candys) {
            sum += candy;
        }
        return sum;
    }
}
