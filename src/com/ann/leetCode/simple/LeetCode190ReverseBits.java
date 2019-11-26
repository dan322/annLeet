package com.ann.leetCode.simple;

public class LeetCode190ReverseBits {

    /**
     * todo ann
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        if (n == 0)
            return 0;
        int reverseN = 1;
        while (n != 0) {
//            reverseN &= (1 );
            n >>= 1;
        }
        return reverseN;
    }
}
