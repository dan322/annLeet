package com.ann.leetCode.simple;

import java.util.HashSet;

/**
 * 时间复杂度：O(m + n)     m: length of J    n: length of n
 */
public class LeetCode771NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        int jewelsNum = 0;
        HashSet<Character> jewels = new HashSet<>();
        for (char chJ: J.toCharArray())
            jewels.add(chJ);
        for (char chS: S.toCharArray()) {
            if (jewels.contains(chS))
                jewelsNum++;
        }
        return jewelsNum;
    }

    /**
     * replaceAll
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones1(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }
}
