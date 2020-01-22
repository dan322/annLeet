package com.ann.leetCode.hard;

import java.util.Arrays;

public class LeetCode552CheckRecord2 {

    public int checkRecord(int n) {
        if (n < 1)
            return 0;
        long[] checkResult = {1, 0, 0, 0, 1, 1, 0};
        long[] checkResultCur;
        for (int i = 2; i <= n; ++i) {
            checkResultCur = new long[7];
            checkResultCur[0] = (checkResult[4] + checkResult[5] + checkResult[6]) % 1000000007;
            checkResultCur[1] = (checkResult[0] + checkResult[1] + checkResult[2] + checkResult[3]) % 1000000007;
            checkResultCur[2] = (checkResult[0] + checkResult[1]) % 1000000007;
            checkResultCur[3] = checkResult[2];
            checkResultCur[4] = checkResultCur[0];
            checkResultCur[5] = checkResult[4];
            checkResultCur[6] = checkResult[5];
            checkResult[0] = checkResultCur[0];
            checkResult[1] = checkResultCur[1];
            checkResult[2] = checkResultCur[2];
            checkResult[3] = checkResultCur[3];
            checkResult[4] = checkResultCur[4];
            checkResult[5] = checkResultCur[5];
            checkResult[6] = checkResultCur[6];
        }
        return  (int)((checkResult[0] + checkResult[1] + checkResult[2] + checkResult[3]
                + checkResult[4] + checkResult[5] + checkResult[6]) % 1000000007);
    }

    /**
     * no matter with p and localtion of p
     * @param n
     * @return
     */
    public int checkRecord1(int n) {
        if (n < 1)
            return 0;
        long a0l0 = 1, a0l1 = 1, a0l2 = 0, a1l0 = 1, a1l1 = 0, a1l2 = 0;
        for (int i = 2; i <= n; ++i) {
            long newA0l0 = (a0l0 + a0l1 + a0l2) % 1000000007;
            a0l2 = a0l1;
            a0l1 = a0l0;
            a0l0 = newA0l0;
            long newA1l0 = (a0l0 + a1l0 + a1l1 + a1l2) % 1000000007;
            a1l2 = a1l1;
            a1l1 = a1l0;
            a1l0 = newA1l0;
        }
        return (int) ((a0l0 + a0l1 + a0l2 + a1l0 + a1l1 + a1l2) % 1000000007);
    }

    /**
     * todo use dp
     * dp[i] : length of i the accept number total
     * @param n
     * @return
     */
    public int checkRecord2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 3;
        dp[2] = 8;
        dp[3] = 19;
        for (int i = 4; i <= n; ++i) {

        }
        return dp[n];
    }
}
