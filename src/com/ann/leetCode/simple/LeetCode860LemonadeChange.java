package com.ann.leetCode.simple;

public class LeetCode860LemonadeChange {
    /**
     * 时间复杂度为O(N)
     * 空间复杂度为O(1)
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int moneyFive = 0, moneyTen = 0;
        for (int bill: bills) {
            if (bill != 5 && moneyFive == 0) {
                return false;
            }
            switch (bill) {
                case 5:
                    moneyFive++;
                    break;
                case 10:
                    moneyFive--;
                    moneyTen++;
                    break;
                case 20:
                    if (moneyTen > 0) {
                        moneyTen--;
                        moneyFive--;
                    } else if (moneyFive >= 3) {
                        moneyFive -= 3;
                    } else {
                        return false;
                    }
                default:;
            }
        }
        return true;
    }
}
