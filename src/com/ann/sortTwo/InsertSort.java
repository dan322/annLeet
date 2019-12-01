package com.ann.sortTwo;

import com.ann.sort.AbstractSort;

public class InsertSort extends AbstractSort {

    @Override
    public void doSort(int[] arr) {
        int sortedMaxIndex = 0, temp;
        for (int i = 1; i < arr.length; ++i) {
            temp = arr[i];
            while (sortedMaxIndex >= 0 && temp < arr[sortedMaxIndex]) {
                arr[sortedMaxIndex + 1] = arr[sortedMaxIndex];
                sortedMaxIndex--;
            }
            arr[sortedMaxIndex + 1] = temp;
            sortedMaxIndex = i;
        }
    }
}
