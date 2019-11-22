package com.ann.leetCode.medium;

import com.sun.xml.internal.ws.encoding.HasEncoding;

import java.util.*;

public class LeetCode212FindWords {

    /**
     * 回溯
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> wordList = new ArrayList();
        HashSet<String> visited = new HashSet();
        HashSet<String> wordSet = new HashSet();
        for (String word: words)
            wordSet.add(word);
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                searchWord("", i, j, board, wordSet, wordList, visited);
            }
        }
        return wordList;
    }

    public void searchWord(String s, int ic, int ir, char[][] board, HashSet<String> wordSet, List<String> wordList, HashSet<String> visited) {
        if (ic < 0 || ir > board[0].length - 1 || visited.contains(s))
            return;
        String str = new StringBuffer(s).append(board[ic][ir]).toString();
        if (wordSet.contains(str))
            wordList.add(s);
        int[][] direction = {{0, 0, 1, -1}, {1, -1, 0, 0}};
        for (int i = 0; i < direction[0].length; ++i) {
            searchWord(str, ic + direction[0][i], ir + direction[1][i] , board , wordSet, wordList, visited);
        }
        visited.add(str);
    }
}
