package com.ann.leetCode.simple;

public class LeetCode58LenOfLastWord {
    /**
     * 库函数 去掉字符串后面的空格 =》 s2 => s2.length - space.index -1
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int len = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; --i) {
            if (chars[i] == ' ') {
                if (0 != len)  return len;
            } else {
                len++;
            }
        }
        return len;
    }
}
