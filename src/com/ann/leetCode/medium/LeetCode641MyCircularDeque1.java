package com.ann.leetCode.medium;

public class LeetCode641MyCircularDeque1 {
    // use array
    private int size;
    private int capacity;
    private int head;
    private int tail;
    private int[] data;

    public LeetCode641MyCircularDeque1(int k) {
        data = new int[k];
        capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull())
            return false;
        data[head] = value;
        head = (head + capacity - 1) % capacity;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull())
            return false;
        data[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty())
            return false;
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        tail = (tail - 1 + capacity) % capacity;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty())
            return -1;
        int index = (head + 1) % capacity;
        return data[index];
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        // 防止负数的出现
        int index = (tail - 1 + capacity) % capacity;
        return data[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
