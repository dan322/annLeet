package com.ann.leetCode.simple;

public class LeetCode706MyHashMap {
    private int size;
    private int capacity = 8;
    private final double loadFactor = 0.75;
    private Node[] data;

    public LeetCode706MyHashMap() {
        data = new Node[capacity];
    }

    public void put(int key, int value) {
        ensureCapacity(size);
        int index = hash(key, capacity);
        /*if (data[index] == null) {
            data[index] = new Node(key, value);
        } else {
            Node tailNode = data[index];
            while (tailNode != null) {
                if (key == tailNode.getKey()) {
                    tailNode.setValue(value);
                    return;
                }
                if (tailNode.getNext() == null) {
                    tailNode.setNext(new Node(key, value));
                    tailNode = null;
                } else
                    tailNode = tailNode.getNext();
            }
        }*/
        // 头插法
        Node current = data[index];
        while (current != null) {
            if (current.getKey() == key) {
                current.setValue(value);
                return;
            }
            current = current.getNext();
        }
        Node newNode = new Node(key, value);
        newNode.setNext(data[index]);
        data[index] = newNode;
        size++;

    }

    public int get(int key) {
        int index = hash(key, capacity);
        Node node = data[index];
        while (node != null) {
            if (key == node.getKey())
                return node.getValue();
            node = node.getNext();
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key, capacity);
        Node prev = null;
        Node node = data[index];
        while (node != null) {
            if (key == node.getKey()) {
                if (prev == null)
                    data[index] = node.getNext();
                else
                    prev.next = node.getNext();
                size--;
                return;
            }
            prev = node;
            node = node.getNext();
        }
    }

    private void ensureCapacity(int newSize) {
         if (capacity * loadFactor <= newSize)
             resize();
    }

    private void resize() {
        int newCapacity = capacity << 1;
        Node[] newData = new Node[newCapacity];
        for (int i = 0; i < data.length; ++i) {
            Node node = data[i];
            while (node != null) {
                Node next = node.getNext();
                node.setNext(null);
                int index = hash(node.getKey(), newCapacity);
                if (newData[index] != null) {
                    Node tailNode = newData[index];
                    while (tailNode.getNext() != null)
                        tailNode = tailNode.getNext();
                    tailNode.setNext(node);
                } else {
                    newData[index] = node;
                }
                node = next;
            }
        }
        data = newData;
        capacity = newCapacity;
    }

    private int hash(int key, int cap) {
        return key % (cap  - 1);
    }


    class Node {
        private int key;
        private int value;
        private Node next;

        public Node(int key, int value) {
            setKey(key);
            setValue(value);
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }
    }
}
