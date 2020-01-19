package com.ann.leetCode.medium;

public class LeetCode518CoinChange2 {

    public int change(int amount, int[] coins) {
        return 0;
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
