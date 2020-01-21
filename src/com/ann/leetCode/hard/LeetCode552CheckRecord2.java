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
     * todo ann less space
     * no matter with p and localtion of p
     * @param n
     * @return
     */
    public int checkRecord1(int n) {
        if (n < 1)
            return 0;
        int[] checkResult = {1, 0, 0, 0, 1, 1, 0};
        int[] checkResultCur;
        for (int i = 2; i <= n; ++i) {
            checkResultCur = new int[7];
            checkResultCur[0] = checkResult[4] + checkResult[5] + checkResult[6];
            checkResultCur[1] = checkResult[0] + checkResult[1] + checkResult[2] + checkResult[3];
            checkResultCur[2] = checkResult[0] + checkResult[1];
            checkResultCur[3] = checkResult[2];
            checkResultCur[4] = checkResult[4] + checkResult[5] + checkResult[6];
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
        int result = checkResult[0] + checkResult[1] + checkResult[2] + checkResult[3]
                + checkResult[4] + checkResult[5] + checkResult[6];
        return result % 1000000007;
    }
}
