package com.ann.leetCode.medium;

public class LeetCode714MaxProfitWithFee {

    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2)
            return 0;
        int[][] profits = new int[prices.length][3];
        profits[0][1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; ++i) {
            profits[i][0] = Math.max(profits[i - 1][0], profits[i - 1][2]);
            profits[i][1] = Math.max(profits[i][0] - prices[i] - fee, profits[i - 1][1]);
            profits[i][2] = prices[i] + profits[i - 1][1];
        }
        return Math.max(profits[prices.length - 1][0], profits[prices.length - 1][2]);
    }

    public int maxProfit1(int[] prices, int fee) {
        if (prices.length < 2)
            return 0;
        int[][] profits = new int[prices.length][2];
        profits[0][1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; ++i) {
            profits[i][1] = Math.max(profits[i - 1][0] - prices[i] - fee, profits[i - 1][1]);
            profits[i][0] = Math.max(prices[i] + profits[i - 1][1], profits[i - 1][0]);
        }
        return profits[prices.length - 1][0];
    }

    public int maxProfit2(int[] prices, int fee) {
        if (prices.length < 2)
            return 0;
        int prevBuy = -prices[0] - fee, maxProfit = 0, buy;
        for (int i = 1; i < prices.length; ++i) {
            buy = Math.max(maxProfit - prices[i] - fee, prevBuy);
            maxProfit = Math.max(prices[i] + prevBuy, maxProfit);
            prevBuy = buy;
        }
        return maxProfit;
    }

    /**
     * optimal of maxProfit2
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit3(int[] prices, int fee) {
        if (prices.length < 2)
            return 0;
        int prevBuy = -prices[0] - fee, maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            maxProfit = Math.max(prices[i] + prevBuy, maxProfit);
            prevBuy = Math.max(maxProfit - prices[i] - fee, prevBuy);
        }
        return maxProfit;
    }
}
