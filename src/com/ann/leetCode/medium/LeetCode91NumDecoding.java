package com.ann.leetCode.medium;

public class LeetCode91NumDecoding {

    /**
     * #0
     * 12   => 2
     * 226  => 3
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        char[] numsChar = s.toCharArray();
        if (numsChar[0] == '0')
            return 0;
        int prevLastOne = 1, prevLastTwo = 0, total = 0, currNum, numTwo;
        for (int i = 1; i < numsChar.length; ++i) {
            currNum = numsChar[i] - '0';
            if (currNum > 0)
                total = prevLastOne + prevLastTwo;
            else
                total = 0;
            numTwo = (numsChar[i - 1]  - '0') * 10 + currNum;
            if (numTwo >= 10 && numTwo <= 26) {
                prevLastTwo = prevLastOne;
                prevLastOne = total;
                total += prevLastTwo;
            } else {
                prevLastTwo = 0;
                prevLastOne = total;
            }
        }
        return total;
    }

    /**
     * #1 improvement of #0
     * @param s
     * @return
     */
    public int numDecodings1(String s) {
        char[] numsChar = s.toCharArray();
        if (numsChar[0] == '0')
            return 0;
        int prevLastOne = 1, prevLastTwo = 0, currNum, numTwo, tmp;
        for (int i = 1; i < numsChar.length; ++i) {
            currNum = numsChar[i] - '0';
            numTwo = (numsChar[i - 1]  - '0') * 10 + currNum;
            tmp = prevLastTwo;
            if (numTwo >= 10 && numTwo <= 26)
                prevLastTwo = prevLastOne;
            else
                prevLastTwo = 0;
            if (currNum > 0)
                prevLastOne += tmp;
            else
                prevLastOne = 0;
        }
        return prevLastOne + prevLastTwo;
    }

    /**
     * 动态递归
     * DP方程: dp[i][0]: i长度的字符串中，最后一位解码的方案数    dp[i][1]： i长度的字符串中，最后两位一起解码的方案数
     * dp[i][0] = validate(num[i]) ? dp[i][0] + dp[i][1]: 0
     * dp[i][1] = validate(num[i - 1] num[i]) ? dp[i][0]: 0
     *
     *
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        char[] numsChar = s.toCharArray();
        if (numsChar[0] == '0')
            return 0;
        int currNum, numTwo;
        int[][] dp = new int[numsChar.length][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i < numsChar.length; ++i) {
            currNum = numsChar[i] - '0';
            numTwo = (numsChar[i - 1]  - '0') * 10 + currNum;
            if (numTwo >= 10 && numTwo <= 26)
               dp[i][1] = dp[i - 1][0];
            if (currNum > 0)
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
        }
        return dp[numsChar.length - 1][0] + dp[numsChar.length - 1][1];
    }

    /**
     * todo ann 递归
     * @param s
     * @return
     */
    public int numDecodings3(String s) {
        char[] numsChar = s.toCharArray();
        if (numsChar[0] == '0')
            return 0;
        int currNum, numTwo;
        int[][] dp = new int[numsChar.length][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i < numsChar.length; ++i) {
            currNum = numsChar[i] - '0';
            numTwo = (numsChar[i - 1]  - '0') * 10 + currNum;
            if (numTwo >= 10 && numTwo <= 26)
                dp[i][1] = dp[i - 1][0];
            if (currNum > 0)
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
        }
        return dp[numsChar.length - 1][0] + dp[numsChar.length - 1][1];
    }

    /**
     * s[i] != '0'
     * 如果 s[i-1]s[i] <= 26, 则 dp[i] = dp[i-1] + dp[i-2]
     * 如果 s[i-1]s[i] > 26, 则 dp[i] = dp[i-1], 这是因为 s[i-1]s[i] 组成的两位数无法翻译
     * s[i] == '0'
     * 如果 s[i-1]s[i] <= 26, 则 dp[i] = dp[i-2], 这是因为 s[i] 无法翻译
     * 还有一些情景直接使得整个序列无法被翻译：
     * 相邻的两个 ‘0’
     * 以 ‘0’ 结尾的大于 26 的数字
     *
     * @param s
     * @return
     */
    public int numDecodings4(String s) {
        char[] charArr = s.toCharArray();
        if (charArr[0] == '0')
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        int ten, one;
        for (int i = 1; i < s.length(); ++i) {
            one = charArr[i] - '0';
            ten = charArr[i - 1] - '0';
            if (0 < one)
                dp[i + 1] = dp[i];
            int twoNum = ten * 10 + one;
            if (10 <= twoNum && 27 > twoNum)
                dp[i + 1] += dp[i - 1];
        }
        return dp[s.length()];
    }

    /**
     * https://leetcode.com/problems/decode-ways/discuss/30358/Java-clean-DP-solution-with-explanation
     * dp[0] means an empty string will have one way to decode,
     * dp[1] means the way to decode a string of size 1
     */
    public int numDecodings5(String s) {
        char[] charArr = s.toCharArray();
        if (charArr[0] == '0')
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        int ten, one;
        for (int i = 2; i < s.length(); ++i) {
            one = charArr[i] - '0';
            ten = charArr[i - 1] - '0';
            if (0 < one)
                dp[i] = dp[i - 1];
            int twoNum = ten * 10 + one;
            if (10 <= twoNum && 27 > twoNum)
                dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
