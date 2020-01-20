package com.ann.leetCode.medium;

public class LeetCode518CoinChange2 {

    /**
     * 以基本情况没有硬币开始组合数量。dp[0] = 1，然后其余等于 0。
     * 遍历所有硬币面值：
     * 对于每个硬币，我们将从金额 0 遍历到 amount：
     * 对于每个 x，计算组合数：dp[x] += dp[x - coin]
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dpChange = new int[amount + 1];
        dpChange[0] = 1;
        for (int i = 0; i < coins.length; ++i) {
            for (int j = 1; j <= amount; ++j) {
                if (coins[i] <= j)
                    dpChange[j] += dpChange[j - coins[i]];
            }
        }
        return dpChange[amount];
    }

    /**
     * improvement of change1
     * @param amount
     * @param coins
     * @return
     */
    public int change2(int amount, int[] coins) {
        int[] dpChange = new int[amount + 1];
        dpChange[0] = 1;
        for (int i = 0; i < coins.length; ++i) {
            for (int j = coins[i]; j <= amount; ++j) {
                dpChange[j] += dpChange[j - coins[i]];
            }
        }
        return dpChange[amount];
    }

    /**
     * time out
     * amout 500
     * coins:[3,5,7,8,9,10,11]
     * @param amount
     * @param coins
     * @return
     */
    public int change1(int amount, int[] coins) {
        if (amount == 0)
            return 1;
        int changeWay = 0;
        for (int i = 0; i < coins.length; ++i) {
            changeWay = doChange(i, coins, changeWay, amount);
        }
        return changeWay;
    }

    public int doChange(int start, int[] coins, int changeWay, int amount) {
        if (amount < 0)
            return changeWay;
        int maxNum, amountCur;
        maxNum = amount / coins[start];
        while (maxNum > 0) {
            amountCur = amount - coins[start] * maxNum--;
            if (amountCur == 0) {
                changeWay += 1;
                continue;
            }
            for (int j = start + 1; j < coins.length; ++j) {
                changeWay = doChange(j, coins, changeWay, amountCur);
            }
        }
        return changeWay;
    }
}
