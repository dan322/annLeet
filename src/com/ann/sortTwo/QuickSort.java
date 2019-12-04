package com.ann.sortTwo;

import com.ann.sort.AbstractSort;

public class QuickSort extends AbstractSort {

    /**
     * 时间复杂度 O（Nlogn)
     * 空间复杂度 o(1) (不算系统站消耗)
     * 稳定
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
        arr[pivot] = arr[end];
        arr[end] = pivotEle;
        for (int i = start; i <= end; ++i) {
            if (arr[i] < pivotEle) {
                int temp = arr[i];
                arr[i] = arr[leftIndex];
                arr[leftIndex++] = temp;
            }
        }
        arr[end] = arr[leftIndex];
        arr[leftIndex] = pivotEle;

        if (leftIndex > start)
            quickSort(arr, start, leftIndex - 1);
        if (leftIndex < end)
            quickSort(arr, leftIndex + 1, end);
    }
}
