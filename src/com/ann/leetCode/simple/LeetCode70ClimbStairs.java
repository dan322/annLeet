package com.ann.leetCode.simple;

public class LeetCode70ClimbStairs {

    /**
     * Recursive with memory
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] stepsArr = new int[n + 1];
        stepsArr[0] = 0;
        return getSteps(n, stepsArr);
    }

    public int getSteps(int n, int[] stepsArr) {
        if (stepsArr[n] == 0) {
            if (n < 4) {
                stepsArr[n] = n;
            } else {
                stepsArr[n] = getSteps(n - 1, stepsArr) + getSteps(n - 2, stepsArr);
            }
        }
        return stepsArr[n];
    }

    /**
     * #2 improvement of #1
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n < 4)
            return n;
        int stepTotal = 0, prevN1 = 3, prevN2 = 2;
        for (int i = 4; i <= n; ++i) {
            stepTotal = prevN1 + prevN2;
            prevN2 = prevN1;
            prevN1 = stepTotal;
        }
        return stepTotal;
    }
}
