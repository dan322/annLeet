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
}
