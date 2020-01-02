package com.ann.leetCode.medium;

public class LeetCode309MaxProfit {
    /**
     * input: 1,2,3,0,2
     * output: 3
     * cooldown: 1 day
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices)
    {
        if (prices.length <= 1)
            return 0;
        int[][] maxProfits = new int[prices.length][2];
        maxProfits[1][1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < prices.length; ++i) {
            maxProfits[i][0] = Math.max(maxProfits[i - 1][0], maxProfits[i - 1][1]);
            maxProfits[i][1] = Math.max(maxProfits[i - 2][0],  maxProfits[i - 1][1]) + prices[i] - prices[i - 1] ;
        }
        return Math.max(maxProfits[prices.length - 1][0], maxProfits[prices.length - 1][1]);
    }

    public int maxProfit1(int[] prices)
    {
        if (prices.length < 2)
            return 0;
        int[] maxProfits = new int[prices.length];
        maxProfits[1] = Math.max(prices[1] - prices[0], 0);
        for (int i = 2; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) {
                maxProfits[i] = Math.max(maxProfits[i - 2] + prices[i] - prices[i - 2], maxProfits[i - 1]);
                if (i >= 3)
                    maxProfits[i] = Math.max(maxProfits[i], maxProfits[i - 3] + prices[i] - prices[i - 1]);
            } else {
                maxProfits[i] = maxProfits[i - 1];
            }
        }
        return 0;
    }
}
