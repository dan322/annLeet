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
        int[][] maxProfits = new int[prices.length][2];
        maxProfits[0][0] = 0;
        maxProfits[0][1] = 0;
        int profit;
        for (int i = 1; i < prices.length; ++i) {
            profit = prices[i] - prices[i - 1];
            maxProfits[i][0] = Math.max(0, profit) + Math.max(maxProfits[i - 1][0], maxProfits[i - 1][1]);
            if (i >= 3)
                maxProfits[i][1] = Math.max(maxProfits[i - 3][1], maxProfits[i - 1][0]) + profit;
        }
        return Math.max(maxProfits[prices.length - 1][0], maxProfits[prices.length - 1][1]);
    }
}
