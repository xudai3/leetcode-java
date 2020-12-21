package com.xd.leetcode.solutions;

/**
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 *
 * 注意：
 *
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 *
 */

public class _747_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        int i = 2;

        while (i < n) {
            // dp[i]由dp[i-1]和dp[i-2]转移而来
            dp[i] = Integer.min(dp[i-1]+cost[i], dp[i-2]+cost[i]);
            i++;
        }
        // 注意倒数第二级可以直接爬两级台阶结束，所以要返回dp[n-1]和dp[n-2]的最小值
        return Integer.min(dp[n-1], dp[n-2]);
    }
}
