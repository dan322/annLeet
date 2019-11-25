package com.ann;

//import com.ann.leetCode.medium.LeetCode153FindMin;
import com.ann.leetCode.medium.*;
import com.ann.leetCode.simple.LeetCode121MaxProfit;
import com.ann.leetCode.simple.LeetCode122MaxProfit2;
import com.ann.leetCode.simple.LeetCode198Rob;

import java.util.List;
//import com.ann.leetCode.simple.LeetCode860LemonadeChange;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "()(()()";
        int[] nums = { 1};
        LeetCode213Rob2 model = new LeetCode213Rob2();
        System.out.println(model.rob(nums));
       /* LeetCode208Trie trie = new LeetCode208Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));*/
       /*char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
       String[] words = {"oath", "pea", "eat", "rain"};
       LeetCode212FindWords model = new LeetCode212FindWords();
        List<String> wordList = model.findWords(board, words);
       for (String str: wordList)
           System.out.println(str);*/
    }
}
