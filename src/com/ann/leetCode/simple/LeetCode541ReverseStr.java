package com.ann.leetCode.simple;

public class LeetCode541ReverseStr {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        char tmp;
        int r, c, swapIndex = 0;
        int comparek = k;
        for (int i = 0; i < chars.length; ++i) {
            r = (i + 1) / (2 * k);
            c = (i + 1) - r * 2 * k;
            if (c > 0 && 2 * c <= comparek) {
                if (c == 1) {
                    swapIndex = (r + 1) * 2 * k - k - c;
                    if (swapIndex >= chars.length) {
                        swapIndex = chars.length - 1;
                        comparek = swapIndex - i + 1;
                    }
                }
                tmp = chars[i];
                chars[i] = chars[swapIndex];
                chars[swapIndex--] = tmp;
            }
        }
        return new StringBuffer().append(chars).toString();
    }

    /**
     * #2 improvement of #1
     * Concise and clear
     * @param s
     * @param k
     * @return
     */
    public String reverseStr1(String s, int k) {
        char[] charArr = s.toCharArray();
        int start, end, length = charArr.length;
        for (int i = 0; i < length; i += 2 * k) {
            start = i;
            end = Math.min(start + k - 1, length - 1);
            while (start < end) {
                char temp = charArr[start];
                charArr[start++] = charArr[end];
                charArr[end--] = temp;
            }
        }
        return String.valueOf(charArr);
    }
}
