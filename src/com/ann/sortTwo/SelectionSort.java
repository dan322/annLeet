package com.ann.sortTwo;

import com.ann.sort.AbstractSort;

public class SelectionSort extends AbstractSort {

    @Override
    public void doSort(int[] arr) {
        int temp, minIndex;
        for (int i = 0; i < arr.length; ++i) {
            temp = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j] > arr[minIndex])
                    minIndex = j;
            }
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
