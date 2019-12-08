package com.ann.leetCode.medium;

import com.sun.xml.internal.ws.encoding.HasEncoding;

import java.util.*;

public class LeetCode212FindWords {

    /**
     * 回溯  DFS
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> wordList = new ArrayList();
        HashSet<String> wordSet = new HashSet();
        boolean[][] visited = new boolean[board.length][board[0].length];
        int maxLen = 0;
        for (String word: words) {
            wordSet.add(word);
            if (word.length() > maxLen)
                maxLen = word.length();
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                searchWord("", i, j, board, wordSet, wordList, visited, maxLen);
            }
        }
        return wordList;
    }

    public void searchWord(String s, int ir, int ic, char[][] board, HashSet<String> wordSet, List<String> wordList, boolean[][] visited, int maxLen) {
        if (ir < 0 || ir >= board.length || ic < 0 || ic > board[0].length - 1 || visited[ir][ic] || s.length() > maxLen)
            return;
        String str = new StringBuffer(s).append(board[ir][ic]).toString();
        if (wordSet.contains(str))
            wordList.add(str);
        visited[ir][ic] = true;
        int[][] direction = {{0, 0, 1, -1}, {1, -1, 0, 0}};
        for (int i = 0; i < direction[0].length; ++i) {
            searchWord(str, ir + direction[0][i], ic + direction[1][i] , board , wordSet, wordList, visited, maxLen);
        }
        visited[ir][ic] = false;
    }


    /**
     * use TRIE
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords2(char[][] board, String[] words) {
        List<String> wordList = new ArrayList();
        // form a trie
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (current.get(ch) == null)
                    current.put(ch, new TrieNode());
                current = current.get(ch);
            }
            current.word = word;
        }

        // search word
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                searchWord2(wordList, root, i, j, board);
            }
        }
        return wordList;
    }

    /**
     * #1 trie search one
     * @param wordList
     * @param node
     * @param r
     * @param c
     * @param board
     */
    public void searchWord1(List<String> wordList, TrieNode node, int r, int c, char[][] board) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || node.get(board[r][c]) == null)
            return;
        // pay attention
        node = node.get(board[r][c]);
        if (node.word != null) {
            wordList.add(node.word);
        }
        int[][] direct = {{0, 0, 1, -1}, {1, -1, 0, 0}};
        for (int i = 0; i < direct[0].length; ++i) {
            searchWord1(wordList, node, r + direct[0][i], c + direct[1][i], board);
        }
    }

    /**
     * #2 improvement of #1 search
     * @param wordList
     * @param node
     * @param r
     * @param c
     * @param board
     */
    public void searchWord2(List<String> wordList, TrieNode node, int r, int c, char[][] board) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
            || board[r][c] == '#' || node.get(board[r][c]) == null)
            return;
        char ch = board[r][c];
        // pay attention
        node = node.get(board[r][c]);
        if (node.word != null) {
            wordList.add(node.word);
            //important de-duplicate
            node.word = null;
        }
        // remark as visited
        board[r][c] = '#';
        int[][] direct = {{0, 0, 1, -1}, {1, -1, 0, 0}};
        for (int i = 0; i < direct[0].length; ++i) {
            searchWord2(wordList, node, r + direct[0][i], c + direct[1][i], board);
        }
        // recover for next dp
        board[r][c] = ch;
    }

    class TrieNode {
        private TrieNode[] chars;
        private String word;
        private static final int r = 26;

        TrieNode() {
            chars = new TrieNode[r];
        }

        public TrieNode get(Character ch) {
            return chars[ch - 'a'];
        }

        public void put(Character ch, TrieNode trieNode) {
            chars[ch - 'a'] = trieNode;
        }
    }
}
