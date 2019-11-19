package com.ann.leetCode.simple;

public class LeetCode122MaxProfit2 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            maxProfit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return maxProfit;
    }

    /**
     * peek and valley  todo ann
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;

        return maxProfit;
    }
}