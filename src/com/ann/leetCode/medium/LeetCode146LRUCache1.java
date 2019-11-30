package com.ann.leetCode.medium;

import java.util.Hashtable;

public class LeetCode146LRUCache1 {
    public int remain;
    private Hashtable<Integer, DListNode> hases;
    private DLinkedList1 cache;

    public LeetCode146LRUCache1(int capacity) {
        hases = new Hashtable<>();
        cache = new DLinkedList1();
        remain = capacity;
    }

    public int get(int key) {
        DListNode node = hases.get(key);
        if (node == null)
            return -1;
        cache.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DListNode node = hases.get(key);
        if (node != null) {
            node.value = value;
            cache.moveToHead(node);
            return;
        }
        if (remain == 0) {
            hases.remove(cache.removeTail().key);
            remain++;
        }
        node = new DListNode();
        node.key = key;
        node.value = value;
        cache.addHead(node);
        hases.put(key, node);
        remain--;
    }
}

/**
 * ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
 * [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
 *
 */

/**
 * head and tail 伪head and 伪tail
 * 简化代码对于特殊情况的处理  null
 * 使得插入的元素都作为中间元素处理
 */
class DLinkedList1 {
    public DListNode head;
    public DListNode tail;

    public DLinkedList1() {
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.prev = head;
    }

    public void moveToHead(DListNode node) {
        if (node.prev == null) {
            addHead(node);
        } else {
            remove(node);
            addHead(node);
        }
    }

    public void addHead(DListNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void remove(DListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public DListNode removeTail() {
        DListNode node = tail.prev;
        remove(node);
        return node;
    }
}

class DListNode {
    public DListNode prev, next;
    public int key, value;
}
