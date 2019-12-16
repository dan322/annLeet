package com.ann.leetCode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode151ReverseWords {
    /**
     * todo ann
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        /*StringBuilder stringBuilder = new StringBuilder();
        Queue<Character> characterQueue = new LinkedList<>();
        boolean prevIsEmpty = true;
        for (int i = s.length(); i > 0; --i) {
            if (s.charAt(i - 1) != ' ') {
                characterQueue.offer(s.charAt(i - 1));
                prevIsEmpty = false;
            } else if (!prevIsEmpty) {
                characterQueue.offer(s.charAt(i - 1));
                prevIsEmpty = true;
            }
        }
        while (!characterQueue.isEmpty())
            stringBuilder.append(characterQueue.poll());
        return stringBuilder.toString();*/
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
     * todo ann 
     * @param s
     * @return
     */
    public String reverseWord2(String s) {

        return s;
    }
}
