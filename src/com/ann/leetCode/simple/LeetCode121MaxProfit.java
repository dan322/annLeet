package com.ann.leetCode.simple;

public class LeetCode121MaxProfit {

    /**
     * #1
     * f(n) = p(n) + f(n - 1)
     * p(n): 第n-1天买入，第n天卖出获取的profit
     * f(n): 第n天获取的最大利润
     * 时间复杂度：O(N)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] profits = new int[prices.length];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            profits[i] = prices[i] - prices[i - 1] + profits[i - 1];
            if (profits[i] < 0) {
                profits[i] = 0;
            } else {
                maxProfit = Math.max(maxProfit, profits[i]);
            }
        }
        return maxProfit;
    }

    /**
     * #2
     * 最小值和最大值之差    （最大值在最小值之后）
     * 时间复杂度：O(N)
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int prevIndex = 0, maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < prices[prevIndex]) {
                prevIndex = i;
            } else {
                maxProfit = Math.max(prices[i] - prices[prevIndex], maxProfit);
            }
        }
        return maxProfit;
    }

    /**
     * #3 improvement of #1
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0, profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] - prices[i - 1] + profit < 0) {
                profit = 0;
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - prices[i - 1] + profit);
            }
        }
        return maxProfit;
    }
}
