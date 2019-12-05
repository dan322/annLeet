package com.ann.leetCode.simple;

public class LeetCode344ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public void reverseString1(char[] s) {
        StringBuffer strBuffer = new StringBuffer().append(s);
        s = strBuffer.reverse().toString().toCharArray();
    }
}
