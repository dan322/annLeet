package com.ann;

//import com.ann.leetCode.medium.LeetCode153FindMin;
import com.ann.leetCode.medium.*;
import com.ann.leetCode.simple.*;

import java.util.*;
//import com.ann.leetCode.simple.LeetCode860LemonadeChange;

public class Main {

    public static void main(String[] args) {
        // write your code here
      /*  String s = "()(()()";
        int[] nums = { 1};
        LeetCode213Rob2 model = new LeetCode213Rob2();
        System.out.println(model.rob(nums));*/
       /* LeetCode208Trie trie = new LeetCode208Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));*/
      /*
      char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
       String[] words = {"oath", "pea", "eat", "rain"};
       LeetCode212FindWords model = new LeetCode212FindWords();
        List<String> wordList = model.findWords1(board, words);
       for (String str: wordList)
           System.out.println(str);
           */
       /* LeetCode120MinimumTotal model = new LeetCode120MinimumTotal();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(-1);

        triangle.add(new ArrayList<Integer>());
        triangle.get(1).add(2);
        triangle.get(1).add(3);

        triangle.add(new ArrayList<Integer>());
        triangle.get(2).add(1);
        triangle.get(2).add(-1);
        triangle.get(2).add(-3);

        triangle.add(new ArrayList<Integer>());
        triangle.get(3).add(4);
        triangle.get(3).add(1);
        triangle.get(3).add(8);
        triangle.get(3).add(3);

        System.out.println(model.minimumTotal(triangle));
        */

        LeetCode231PowerOfTwo model = new LeetCode231PowerOfTwo();
        System.out.println(model.isPowerOfTwo(6));
    }
}
