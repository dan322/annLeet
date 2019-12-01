package com.ann.leetCode.simple;

public class LeetCode1122RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int index = 0;
        int[] countNum = new int[1001];
        for (int i: arr1) {
            countNum[i]++;
        }
        for (int j: arr2) {
            while (countNum[j]-- > 0) {
                arr1[index++] = j;
            }
        }
        for (int i = 0; i < countNum.length; ++i) {
            while (countNum[i]-- > 0) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }

    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int index = 0, maxValue = arr1[1], minValue = arr1[1];
        for (int i: arr1) {
            if (i < minValue) {
                minValue = i;
            } else if (i > maxValue) {
                maxValue = i;
            }
        }
        int[] countNum = new int[maxValue - minValue + 1];
        for (int i: arr1) {
            countNum[i - minValue]++;
        }
        for (int j: arr2) {
            while (countNum[j - minValue]-- > 0) {
                arr1[index++] = j;
            }
        }
        for (int i = 0; i < countNum.length; ++i) {
            while (countNum[i]-- > 0) {
                arr1[index++] = i + minValue;
            }
        }
        return arr1;
    }
}
