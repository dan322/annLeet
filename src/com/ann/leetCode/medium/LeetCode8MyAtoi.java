package com.ann.leetCode.medium;

public class LeetCode8MyAtoi {
    /**
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        boolean isValid = false, isNegative = false;
        int num = 0, charNum, boundNum = Integer.MAX_VALUE / 10;
        for (char ch: str.toCharArray()) {
            if (isValid == false && ch == ' ')
                continue;
            else if (isValid == false && (ch == '+' || ch == '-')) {
                isNegative = ch == '-';
                isValid = true;
                if (isNegative)
                    boundNum = Integer.MIN_VALUE / 10;
            } else if (ch >= '0' && ch <= '9') {
                charNum = ch - '0';
                if (isNegative) {
                    if (num < boundNum || Integer.MIN_VALUE - num * 10 + charNum >= 0)
                        return Integer.MIN_VALUE;
                    else
                        num = num * 10 - charNum;
                } else {
                    if (num > boundNum || Integer.MAX_VALUE - num * 10 <= charNum)
                        return Integer.MAX_VALUE;
                    else
                        num = num * 10 + charNum;
                }
                isValid = true;
            } else
                return num;
        }
        return num;
    }

    public int myAtoi1(String str) {
        int num = 0, boundNum, i, charNum;
        boolean isNegative = false;
        char[] charArr = str.toCharArray();
        for (i = 0; i < str.length();) {
            if (charArr[i] == ' ') {
                ++i;
                continue;
            }
            break;
        }

        if (charArr[i] == '-') {
            ++i;
            isNegative = true;
            boundNum = Integer.MIN_VALUE / 10;
        } else {
            boundNum = Integer.MAX_VALUE / 10;
            if (charArr[i] == '+')
                ++i;
        }
        for (; i < str.length();) {
            if (charArr[i] >= '0' && charArr[i] <= '9') {
                charNum = charArr[i] - '0';
                if (isNegative) {
                    if (num < boundNum || Integer.MIN_VALUE - num * 10 + charNum >= 0)
                        return Integer.MIN_VALUE;
                    else
                        num = num * 10 - charNum;
                } else if (num > boundNum || Integer.MAX_VALUE - num * 10 <= charNum)
                    return Integer.MAX_VALUE;
                else
                    num = num * 10 + charNum;
                ++i;
            } else
                return num;
        }
        return num;
    }

    /**
     * #3 optimize
     * @param str
     * @return
     */
    public int myAtoi2(String str) {
        int num = 0, boundNum = Integer.MAX_VALUE / 10, i = 0, charNum, sign = 1;
        char[] charArr = str.toCharArray();
        while (i < str.length() && charArr[i] == ' ')
            ++i;

        if (charArr[i] == '-' || charArr[i] == '+')
            sign = charArr[i++] == '-' ? -1: 1;

        while(i < str.length() && charArr[i] >= '0' && charArr[i] <= '9') {
            charNum = charArr[i++] - '0';
            if (num > boundNum || (num == boundNum && charNum > 7)) {
                return sign == -1
                        ? Integer.MIN_VALUE
                        : Integer.MAX_VALUE;
            }
            num = num * 10 + charNum;
        }
        return num * sign;
    }
}
