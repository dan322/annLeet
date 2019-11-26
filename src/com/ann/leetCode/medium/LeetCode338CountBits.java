package com.ann.leetCode.medium;

public class LeetCode338CountBits {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            bits[i] = hammingWeight(i);
        }
        return bits;
    }

    public int hammingWeight(int n) {
        int hammingWeight = 0;
        while (n != 0) {
            hammingWeight++;
            n &= n - 1;
        }
        return hammingWeight;
    }

    /**
     * todo ann
     * dp + 最高有效位
     * @param num
     * @return
     */
    public int[] countBits1(int num) {
        int[] bits = new int[num + 1];

        return bits;
    }

    /**
     * todo ann
     * 最低有效位 + dp
     * @param num
     * @return
     */
    public int[] countBits2(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
        }
        return bits;
    }

    /**
     * todo ann
     * 最后设置位 + dp
     * @param num
     * @return
     */
    public int[] countBits3(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
        }
        return bits;
    }

}
