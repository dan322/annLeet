package com.ann.leetCode.medium;

public class LeetCode707MyLinkedList {
    private int size;
    private Node head;
    private Node tail;

    public LeetCode707MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (size <= index)
            return -1;
        Node current = head;
        for (int i = 0; i < index; ++i)
            current = current.getNext();
        return current.getValue();
    }

    /** Add a node of value val before the first element of the linked list.
     *  After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        Node newNode = new Node(val);
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node current = head;
        for (int i = 1; i < index; ++i)
            current = current.getNext();
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        if (index == size)
            tail = newNode;
        ++size;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size)
            return;
        if (size == 1)
            head = tail = null;
        else if (index == 0)
            head = head.getNext();
        else {
            Node current = head;
            for (int i = 0; i < index - 1; ++i)
                current = current.getNext();
            current.setNext(current.getNext().getNext());
            if (index == size - 1)
                tail = current;
        }
        --size;
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
