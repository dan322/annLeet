package com.ann.leetCode.medium;

import java.util.LinkedHashMap;

public class LeetCode146LRUCache2 {
    private int capacity;
    private LinkedHashMap<Integer, Integer> hashLinked;
    /**
     * todo ann
     * use linkedHashMap to realize LRU cache
     * @param capacity
     */
    public LeetCode146LRUCache2(int capacity) {
        capacity = capacity;
        hashLinked = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!hashLinked.containsKey(key))
            return -1;
        return hashLinked.get(key);
    }

    public void put(int key, int value) {
        if (hashLinked.containsKey(key))
            hashLinked.remove(key);
        else if (capacity == hashLinked.size())
            hashLinked.remove(capacity - 1);
        hashLinked.put(key, value);
    }
}
