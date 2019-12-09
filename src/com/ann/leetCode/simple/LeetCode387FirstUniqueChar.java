package com.ann.leetCode.simple;

public class LeetCode387FirstUniqueChar {

    /**
     * 时间复杂度：O(n)
     * @param s
     * @return
     */
    public int firstUniqeChar(String s) {
        int[] charCount = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            int index = chars[i] - 'a';
            if (charCount[index] == 0) {
                charCount[index] = i + 1;
            } else if (charCount[index] > 0) {
                charCount[index] = -1;
            }
        }
        for (char ch: chars) {
            if (charCount[ch - 'a'] > 0)
                return charCount[ch - 'a'] - 1;
        }
        return -1;
    }

    /**
     *时间复杂度：O(n)
     * @param s
     * @return
     */
    public int firstUniqeChar1(String s) {
        int[] charCount = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            int index = chars[i] - 'a';
            if (charCount[index] == 0) {
                charCount[index] = i + 1;
            } else if (charCount[index] > 0) {
                charCount[index] = -1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int count: charCount) {
            if (count > 0 && (count - 1) < min)
                min = count - 1;
        }
        return min == Integer.MAX_VALUE ? -1: min;
    }

    /**
     * 使用库函数
     * @param s
     * @return
     */
    public int firstUniqeChar2(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            int index = s.indexOf(chars[i]);
            if (index != -1 && index != s.lastIndexOf(chars[i]))
                return i;
        }
        return -1;
    }
}
