package com.ann.leetCode.simple;

public class LeetCode242ValidAnagram {
    /**
     * #1 时间复杂度： O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] countS = new int[26];
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (char i : charS)
            countS[i - 'a']++;
        for (char i : charT) {
            countS[i - 'a']--;
            if (countS[i - 'a'] < 0)
                return false;
        }
        for (int j : countS) {
            if (j != 0)
                return false;
        }
        return true;
    }

    /**
     * #2 improvement of #1
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        int[] countS = new int[26];
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (char i : charS)
            countS[i - 'a']++;
        for (char i : charT) {
            countS[i - 'a']--;
            if (countS[i - 'a'] < 0)
                return false;
        }
        return true;
    }

    /**
     * #3 improvement of #1
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] countS = new int[26];
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (int i = 0; i < charS.length; ++i) {
            countS[charS[i] - 'a']++;
            countS[charT[i] - 'a']--;
        }
        for (int j : countS) {
            if (j != 0)
                return false;
        }
        return true;
    }
}
