package com.ann.leetCode.simple;

import java.util.LinkedList;

// use linkedList
public class LeetCode705MyHashSet1 {
    private Bucket[] data;
    private final int capacity = 769;

    public LeetCode705MyHashSet1() {
        data = new Bucket[capacity];
        for (int i = 0; i < capacity; ++i)
            data[i] = new Bucket();
    }

    public void add(int key) {
        int index = hash(key);
        data[index].insert(key);
    }

    public void remove(int key) {
        int index = hash(key);
        data[index].delete(key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        return data[index].exists(key);
    }

    private int hash(int key) {
        return key % capacity;
    }

    class Bucket {
        LinkedList<Integer> container;

        Bucket() {
            container = new LinkedList<>();
        }

        public void insert(int key) {
            if (!exists(key))
                container.add(key);
        }

        public void delete(int key) {
            container.remove(key);
        }

        public boolean exists(int key) {
            return container.indexOf(key) != -1 ;
        }
    }
}
