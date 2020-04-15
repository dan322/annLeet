package com.ann.leetCode.medium;

public class LeetCode641MyCircularDeque {
    private Node head,
                 tail;
    private int capacity;
    private int size;

    public LeetCode641MyCircularDeque(int k) {
        capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull())
            return false;
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull())
            return false;
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty())
            return false;
        head = head.getNext();
        if (head != null)
            head.setPrev(null);
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        tail = tail.getPrev();
        if (tail != null)
            tail.setNext(null);
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty())
            return -1;
        return head.getValue();
    }

    public int getRear() {
        if (isEmpty())
            return -1;
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
        private Node prev;

        public Node(int value) {
            setValue(value);
        }

        public Node(int value, Node next) {
            setValue(value);
            setNext(next);
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }
    }
}
