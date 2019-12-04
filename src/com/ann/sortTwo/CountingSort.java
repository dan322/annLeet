package com.ann.sortTwo;

import com.ann.sort.AbstractSort;

public class CountingSort extends AbstractSort {

    /**
     * 局限性： 适用于整形
     * 时间复杂度： O(n)
     * 空间复杂度： O(max - min + 1)   (数组最大值 最小值差)
     * 不稳定
     * @param arr
     */
    @Override
    public void doSort(int[] arr) {
        int maxValue = arr[0], minValue = arr[0];
        // find minvalue and maxvalue to determine the length of counting array (reduce space)
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }
        int length = maxValue - minValue + 1;
        int[] countingArr = new int[length];
        // counting (count each number appear times)
        for (int value : arr)
            countingArr[value - minValue]++;
        // form new sorted array
        int index = 0;
        for (int i = 0; i < length; ++i) {
            while (countingArr[i] > 0)
                arr[index++] = i + minValue;
        }
    }
}
