package com.ann.leetCode.simple;

public class LeetCode557ReverseWord {
    public String reverseWords(String s) {
        char[] charArr = s.toCharArray();
        boolean needReverse = false;
        int start = -1;
        for (int i = 0; i < charArr.length; ++i) {
            if (charArr[i] == ' ') {
                if (needReverse)
                    reverseWord(charArr, start + 1, i - 1);
                start = i;
                needReverse = false;
            } else {
                needReverse = true;
            }
        }
        if (needReverse)
            reverseWord(charArr, start + 1, charArr.length - 1);
        return String.valueOf(charArr);
    }

    public void reverseWord(char[] charArr, int start, int end) {
        while (start < end) {
            char temp = charArr[start];
            charArr[start++] = charArr[end];
            charArr[end--] = temp;
        }
    }

    /**
     * WORD之间只有一个空格
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        int start = -1;
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; ++i) {
            if (charArr[i] == ' ') {
                reverseWord(charArr, start + 1, i - 1);
                start = i;
            }
        }
        reverseWord(charArr, start + 1, charArr.length - 1);
        return String.valueOf(charArr);
    }

    /**
     * 使用库函数
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        StringBuffer str = new StringBuffer();
        String[] words = s.split(" ");
        for (String word: words) {
            str.append((new StringBuffer(word)).reverse().toString() + " ");
        }
        return str.toString();
    }

    /**
     * 使用库函数
     * @param s
     * @return
     */
    public String reverseWords3(String s) {
        StringBuffer str = new StringBuffer();
        StringBuffer word = new StringBuffer();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; ++i) {
            if (charArr[i] == ' ') {
                str.append(word.reverse());
                str.append(charArr[i]);
                word.setLength(0);
            } else {
                word.append(charArr[i]);
            }
        }
        return str.toString();
    }
}
