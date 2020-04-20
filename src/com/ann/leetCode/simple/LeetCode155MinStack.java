package com.ann.leetCode.simple;

public class LeetCode155MinStack {
    private int[] data;
    private int[] minIndexData;
    private int size;
    private int minSize;

    public LeetCode155MinStack() {
        data = new int[100000];
        minIndexData = new int[10000];
    }

    public void push(int x) {
        data[size++] = x;
        if (minSize == 0)
            minIndexData[minSize++] = x;
        else if (x <= minIndexData[minSize - 1])
            minIndexData[minSize++] = x;
    }

    public void pop() {
        if (data[size - 1] == minIndexData[minSize - 1])
            minSize--;
        size--;
    }

    public int top() {
        return data[size - 1];
    }

    public int getMin() {
        return minIndexData[minSize - 1];
    }
}
