package com.ann.leetCode.simple;

public class LeetCode_709_ToLowerCase {

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] >= 'A' && chars[i] <= 'Z')
                chars[i] = (char) (chars[i] + 32);
        }
        return new StringBuffer().append(chars).toString();
    }

    /**
     * 大写变小写、小写变大写 : ASCII码 ^= 32
     * 大写变小写、小写变小写 : ASCII码 |= 32
     * 小写变大写、大写变大写 : ASCII码 &= -33
     *  A   01000001        a   01100001
     *  B   01000010        b   01100010
     *  C   01000011        c   01100010
     * @param str
     * @return
     */
    public String toLowerCase1(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            chars[i] = (char) (chars[i] ^ 32);
        }
        return new StringBuffer().append(chars).toString();
    }
}
