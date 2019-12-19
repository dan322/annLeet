package com.ann.leetCode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode151ReverseWords {
    /**
     * #0
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] strArr = s.trim().split(" +");
        StringBuilder stringBuilder = new StringBuilder();
        int index = strArr.length;
        while (index-- > 0) {
            stringBuilder.append(strArr[index]);
            if (index > 0)
                stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

    /**
     * #1 improvement of #0
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        String[] strArr = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int index = strArr.length;
        while (index-- > 0 && strArr[index].length() > 0) {
            stringBuilder.append(strArr[index]);
            if (index > 0)
                stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

    /**
     * #2
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int wordEnd = s.length() - 1, wordStart = 0;
        char[] charArr = s.toCharArray();
        boolean prevIsEmpty = true;
        for (int i = wordEnd; i >= 0; i--) {
            if (prevIsEmpty && charArr[i] != ' ') {
                wordEnd = i;
                prevIsEmpty = false;
                if (wordStart > wordEnd)
                    stringBuilder.append(' ');
            }
            if (!prevIsEmpty && (i == 0 || charArr[i - 1] == ' ')) {
                wordStart = i - 1;
                while (wordStart < wordEnd) {
                    stringBuilder.append(charArr[++wordStart]);
                }
                prevIsEmpty = true;
            }
        }
        return stringBuilder.toString();
    }
}
