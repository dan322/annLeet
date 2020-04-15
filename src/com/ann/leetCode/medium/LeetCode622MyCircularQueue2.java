package com.ann.leetCode.medium;

public class LeetCode622MyCircularQueue2 {
    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public LeetCode622MyCircularQueue2(int k) {
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        Node node = new Node(value);
        if (size++ == 0)
            head = tail = node;
        else {
            tail.setNext(node);
            tail = node;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        head = head.getNext();
        if (--size == 0)
            tail = head;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return head.getValue();
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return tail.getValue();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    class Node {
        private int value;
        private Node next;

        public Node(int value) {
            setValue(value);
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }
    }
}
