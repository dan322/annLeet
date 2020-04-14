package com.ann.leetCode.simple;

public class LeetCode705MyHashSet {
    private int size;
    private int capacity = 8;
    private final double loadFactor = 0.75;
    private Node[] data;

    public LeetCode705MyHashSet() {
        data = new Node[capacity];
    }

    public void add(int key) {
        ensureCapacity(size);
        int index = hashIndex(key, capacity);
        Node current = data[index];
        if (current == null) {
            data[index] = new Node(key);
            size++;
        } else {
            while (current.getValue() != key && current.getNext() != null)
                current = current.next;
            if (current.getValue() != key) {
                current.setNext(new Node(key));
                size++;
            }
        }
    }

    public void remove(int key) {
        int index = hashIndex(key, capacity);
        Node current = data[index],
            prev = null;
        while (current != null) {
            if (current.getValue() == key) {
                if (null != prev)
                    prev.setNext(current.getNext());
                else
                    data[index] = current.getNext();
                size--;
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    public boolean contains(int key) {
        int index = hashIndex(key,capacity);
        Node current = data[index];
        while (current != null) {
            if (current.getValue() == key)
                return true;
            current = current.getNext();
        }
        return false;
    }

    private int hashIndex(int key, int cap) {
        return key % (cap - 1);
    }

    private void ensureCapacity(int newSize) {
        if (loadFactor * capacity <= newSize)
            resize();
    }

    private void resize() {
        int newCapacity = capacity << 1;
        Node[] newData = new Node[newCapacity];
        for (int i = 0; i < data.length; ++i) {
            Node current = data[i];
            while (current != null) {
                Node next = current.getNext();
                int index = hashIndex(current.getValue(), newCapacity);
                Node tailNode = newData[index];
                if (tailNode == null) {
                    newData[index] = new Node(current.getValue());
                } else {
                    while (tailNode.getNext() != null)
                        tailNode = tailNode.next;
                    tailNode.setNext(new Node(current.getValue()));
                }
                current = next;
            }
        }
        data = newData;
        capacity = newCapacity;
    }

    class Node {
        private int value;
        private Node next;

        public Node(int value) {
            setValue(value);
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public int getValue() {
            return value;
        }
    }
}
