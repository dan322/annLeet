package com.ann.leetCode.simple;

public class LeetCode190ReverseBits {

    /**
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int reverseN = 0;
        for (int i = 0; i < 32; ++i) {
            reverseN <<= 1;
            reverseN |= (n & 1);
            n >>= 1;
        }
        return reverseN;
    }
}
