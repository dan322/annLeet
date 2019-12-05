package com.ann.sortTwo;

import com.ann.sort.AbstractSort;

import java.util.Arrays;

public class MergeSort extends AbstractSort {

    /**
     * 时间复杂度：O（Nlogn)
     * 稳定
     * divide and conquer
     * @param arr
     */
    @Override
    public void doSort(int[] arr) {
         for (int i: mergeSort(arr))
             System.out.println(i);
    }

    public int[] mergeSort(int[] arr) {
        if (arr.length < 2)
            return arr;
        int pivot = arr.length >> 1;
        int[] arrLeft = mergeSort(Arrays.copyOfRange(arr, 0, pivot));
        int[] arrRight = mergeSort(Arrays.copyOfRange(arr, pivot, arr.length));
        return merge(arrLeft, arrRight);
    }

    public int[] merge(int[] arrLeft, int[] arrRight)
    {
        int index = 0, leftIndex= 0, rightIndex = 0;
        int[] newArr = new int[arrLeft.length + arrRight.length];
        while (leftIndex < arrLeft.length && rightIndex < arrRight.length) {
            if (arrLeft[leftIndex] <= arrRight[rightIndex]) {
                newArr[index++] = arrLeft[leftIndex++];
            } else {
                newArr[index++] = arrRight[rightIndex++];
            }
        }
        while (leftIndex < arrLeft.length)
            newArr[index++] = arrLeft[leftIndex++];
        while (rightIndex < arrRight.length)
            newArr[index++] = arrRight[rightIndex++];
        return newArr;
    }
}
