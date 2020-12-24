package com.xd.leetcode.solutions;

import java.util.Arrays;

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
