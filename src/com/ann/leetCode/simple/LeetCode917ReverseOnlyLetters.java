package com.ann.leetCode.simple;

import java.util.Stack;

public class LeetCode917ReverseOnlyLetters {

    /**
     * 时间复杂度O(N） N：s.length
     * 输入："a-bC-dEf-ghIj"
     * 输出："j-Ih-gfE-dCba"
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {
        int i = 0, j = S.length() - 1;
        char[] charArr = S.toCharArray();
        char temp;
        while (i < j) {
            if (!((charArr[i] >= 'a' && charArr[i] <= 'z')
                    || (charArr[i] >= 'A' && charArr[i] <= 'Z'))) {
                i++;
                continue;
            }
            while (j >= i && j < charArr.length && !((charArr[j] >= 'a' && charArr[j] <= 'z')
                    || (charArr[j] >= 'A' && charArr[j] <= 'Z'))) {
                j--;
            }
            temp = charArr[i];
            charArr[i++] = charArr[j];
            charArr[j--] = temp;
        }
        return String.valueOf(charArr);
    }

    /**
     * 时间复杂度O(N） N：s.length
     * @param S
     * @return
     */
    public String reverseOnlyLetters1(String S) {
        int i = 0;
        Stack<Character> letterStack = new Stack();
        char ch;
        while (i < S.length()) {
            ch = S.charAt(i++);
            if (Character.isLetter(ch))
                letterStack.push(ch);
        }
        i = 0;
        StringBuilder str = new StringBuilder();
        while (i < S.length()) {
            ch = S.charAt(i++);
            if (Character.isLetter(ch))
                str.append(letterStack.pop());
            else
                str.append(ch);
        }
        return str.toString();
    }
}
