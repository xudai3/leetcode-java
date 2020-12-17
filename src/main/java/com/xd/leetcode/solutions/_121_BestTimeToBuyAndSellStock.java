package com.xd.leetcode.solutions;

public class _121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 每个价格与历史最低价格计算差值，如果比之前的最大利润高则更新
            // 如果卖出价格比买入价格低则为负数一定不会更新最大利润
            maxProfit = Integer.max(maxProfit, prices[i]-minPrice);
            // 总是保存最低价格
            minPrice = Integer.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
    public int maxProfit2Pointer(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int dateBuy = 0;
        int dateSell = 1;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 如果买入价格比当前价格低，更新买入时间并把卖出时间设为买入的后一天保证买入后才能卖出
            if (prices[dateBuy] > prices[i]) {
                dateBuy = i;
                dateSell = dateBuy + 1;
            } else {
                if (dateBuy < dateSell) {
                    dateSell = i;
                    maxProfit = Integer.max(maxProfit, prices[dateSell]-prices[dateBuy]);
                }
            }
        }
        return maxProfit;
    }
}
