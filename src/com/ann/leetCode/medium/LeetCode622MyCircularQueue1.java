package com.ann.leetCode.medium;

public class LeetCode622MyCircularQueue1 {
    private int[] data;
    private int headIndex;
    private int tailIndex;
    private int capacity;

    public LeetCode622MyCircularQueue1(int k) {
        capacity = k;
        data = new int[capacity];
        for (int i = 0; i < capacity; ++i)
            data[i] = -1;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        data[tailIndex] = value;
        tailIndex = getNextIndex(tailIndex);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        data[headIndex] = -1;
        headIndex = getNextIndex(headIndex);
        return true;
    }

    public int Front() {
        return data[headIndex];
    }

    public int Rear() {
        return data[getPrevIndex(tailIndex)];
    }

    public boolean isEmpty() {
        return data[headIndex] == -1;
    }

    public boolean isFull() {
        return data[tailIndex] != -1;
    }

    private int getNextIndex(int currentIndex) {
        return currentIndex + 1 == capacity ? 0: currentIndex + 1;
    }

    private int getPrevIndex(int index) {
        return index == 0 ? capacity - 1: index - 1;
    }
}
