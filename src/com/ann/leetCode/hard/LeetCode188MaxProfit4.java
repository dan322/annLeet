package com.ann.leetCode.hard;

public class LeetCode188MaxProfit4 {

    /**
     * todo ann week
     * input:  [2,4,1], k = 2
     * output: 2
     * input:  [3,2,6,5,0,3], k = 2
     * output: 7
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length < 2)
            return 0;
        int[][] maxProfits = new int[k + 1][prices.length];
        int maxProfit;
        for (int j = 1; j <= k; ++j) {
            maxProfits[j][0] = 0;
            for (int i = 1; i < prices.length; ++i) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit = maxProfits[j][i - 1] + prices[i] - prices[i - 1];
                } else {
                    maxProfit = Math.max(maxProfits[j - 1][i - 1], i > 2 ? maxProfits[j][i - 2]: 0);
                }
                maxProfits[j][i] = maxProfit;
            }
        }
        return maxProfits[k][prices.length - 1];
    }
}
