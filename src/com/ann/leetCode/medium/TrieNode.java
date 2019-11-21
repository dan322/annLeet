package com.ann.leetCode.medium;

public class TrieNode {
    TrieNode[] links;
    private boolean isEnd;
    private final int size = 26;

    TrieNode() {
        links = new TrieNode[size];
    }

    public boolean containsKey (char c) {
        return links[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
