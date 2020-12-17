package com.xd.leetcode.solutions;

import org.junit.jupiter.api.Test;

class _714_BestTimeToBuyAndSellStockWithTtransactionFeeTest {

    @Test
    void maxProfit2D() {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        _714_BestTimeToBuyAndSellStockWithTtransactionFee b = new _714_BestTimeToBuyAndSellStockWithTtransactionFee();
        int profit = b.maxProfit2D(prices, fee);
        System.out.println(profit);
    }
    @Test
    void maxProfit1D() {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        _714_BestTimeToBuyAndSellStockWithTtransactionFee b = new _714_BestTimeToBuyAndSellStockWithTtransactionFee();
        int profit = b.maxProfit1D(prices, fee);
        System.out.println(profit);
    }
}