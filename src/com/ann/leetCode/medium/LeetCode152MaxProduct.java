package com.ann.leetCode.medium;

public class LeetCode152MaxProduct {

    /**
     * #1
     * [2, -3, 3, -2, 4] error when occur discontinuous negative number
     * 2,3,-2,4     output: 6
     * -2, 0, -1    output: 0
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int[] productNum = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0 && i + 1 < nums.length && nums[i + 1] < 0) {
                productNum[i] = nums[i] * nums[i + 1];
                productNum[++i] = 1;
            } else {
                productNum[i] = nums[i];
            }
        }
        int maxProduct = productNum[0], prevMax = productNum[0];
        for (int i = 1; i < nums.length; ++i) {
            prevMax = Math.max(prevMax * productNum[i], productNum[i]);
            maxProduct = Math.max(prevMax, maxProduct);
        }
        return maxProduct;
    }

    /**
     * [2, -3, 3, -2, 4] error when occur discontinuous negative number
     * #2 improvement of #1
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        int prevMax = nums[0], maxProduct = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < 0 && i + 1 < nums.length && nums[i + 1] < 0)
                prevMax = Math.max(prevMax, 1) * nums[i] * nums[++i];
            else
                prevMax = Math.max(prevMax, 1) * nums[i];
            maxProduct = Math.max(prevMax, maxProduct);
        }
        return maxProduct;
    }

    /**
     * todo ann
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        int prevMax = nums[0], maxProduct = nums[0], prevNegativeMin = nums[0];

        return maxProduct;
    }
}
