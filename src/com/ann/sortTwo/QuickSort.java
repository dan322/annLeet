package com.ann.sortTwo;

import com.ann.sort.AbstractSort;

public class QuickSort extends AbstractSort {

    /**
     * todo ann
     * @param arr
     */
    @Override
    public void doSort(int[] arr) {
        if (arr.length < 2)
            return;
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int pivot = ((end - start) >> 1) + start;
        //sort arr[i] < arr[pivot] then 将arr[i]放在arr[pivot]左边，否则放在arr[pivot]右边
        int pivotEle = arr[pivot], leftIndex = start;
        for (int i = start; i <= end; ++i) {
            if (arr[i] < pivotEle) {
                if (i > leftIndex) {
                    int temp = arr[i];
                    arr[i] = arr[leftIndex];
                    arr[leftIndex] = temp;
                }
                leftIndex++;
            }
        }
        if (leftIndex < pivot)
            arr[pivot] = arr[leftIndex];
        arr[leftIndex] = pivotEle;

        if (leftIndex > start)
            quickSort(arr, start, leftIndex );
        if (leftIndex < end)
            quickSort(arr, leftIndex + 1, end);
    }
}
