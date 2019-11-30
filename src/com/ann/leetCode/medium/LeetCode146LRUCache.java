package com.ann.leetCode.medium;

import java.util.Hashtable;

public class LeetCode146LRUCache {
    private Hashtable<Integer, ListNode> hashes;
    private DLinkedList cache;
    private int remain;

    public LeetCode146LRUCache(int capacity) {
        hashes = new Hashtable<>();
        cache = new DLinkedList();
        remain = capacity;
    }

    public int get(int key) {
        ListNode listNode = hashes.get(key);
        if (listNode == null)
            return -1;
        cache.remove(listNode);
        cache.addHead(listNode);
        return listNode.value;
    }

    public void put(int key, int value) {
        ListNode node = hashes.get(key);
        if (node != null) {
            node.value = value;
            cache.remove(node);
            cache.addHead(node);
            return;
        }
        if (remain <= 0) {
            hashes.remove(cache.getTail().key);
            cache.removeTail();
            remain++;
        }
        node = new ListNode();
        node.key = key;
        node.value = value;
        cache.addHead(node);
        hashes.put(key, node);
        remain--;
    }
}
