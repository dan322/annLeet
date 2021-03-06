package com.ann.leetCode.medium;

public class LeetCode208Trie {
    private TrieNode root;

    public LeetCode208Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char ch;
        TrieNode current = root;
        for (int i = 0; i < word.length(); ++i) {
            ch = word.charAt(i);
            if (!current.containsKey(word.charAt(i))) {
                current.put(ch, new TrieNode());
            }
            current = current.get(ch);
        }
        current.setEnd();
    }

    public boolean search(String word) {
        char ch;
        TrieNode current = root;
        for (int i = 0; i < word.length(); ++i) {
            ch = word.charAt(i);
            if (!current.containsKey(word.charAt(i))) {
                return false;
            }
            current = current.get(ch);
        }
        return current.isEnd();
    }

    public boolean startsWith(String prefix) {
        char ch;
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); ++i) {
            ch = prefix.charAt(i);
            if (!current.containsKey(prefix.charAt(i))) {
                return false;
            }
            current = current.get(ch);
        }
        return true;
    }
}
