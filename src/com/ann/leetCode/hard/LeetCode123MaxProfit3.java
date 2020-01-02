package com.ann.leetCode.hard;

public class LeetCode123MaxProfit3 {
    /**
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] maxProfits = new int[prices.length][3];
        int minPrice;
        for (int k = 1; k < 3; ++k) {
            minPrice = prices[0];
            for (int i = 1; i < prices.length; ++i) {
                minPrice = Math.min(minPrice, prices[i] - maxProfits[i - 1][k - 1]);
                maxProfits[i][k] = Math.max(maxProfits[i - 1][k], prices[i] - minPrice);
            }
        }
        return maxProfits[prices.length - 1][2];
    }

    /**
     * todo ann less space spend
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {

        return 0;
    }

    /**
     * todo ann use dp write again
     * @param prices
     * @return
     */
    public int maxProfit2(int prices) {

        return 0;
    }
}
