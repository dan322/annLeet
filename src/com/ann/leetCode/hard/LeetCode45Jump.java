package com.ann.leetCode.hard;

public class LeetCode45Jump {
    /**
     * #1
     * 时间复杂度为 O(N)   N为数组元素个数
     * 贪心算法    每一步选择能走最远的
     * （证明： 如果最后一个能到达目标的最优的点i, 则该点i一定位于点J右侧（j表示到点i的前一个点））
     * 我们每次在可跳范围内选择可以使得跳的更远的位置
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        return jumpNum(nums, 1, 0);
    }

    public int jumpNum(int[] nums, int step, int current) {
        int oldMax = nums[current] + current;
        int maxIndex = current;
        if (oldMax >= nums.length - 1)
            return step;
        for (int i = current + 1; i <= oldMax; i++) {
            if (nums[i] + i >= nums.length - 1)
                return step + 1 ;
            if (nums[i] + i > maxIndex + nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return jumpNum(nums, step + 1, maxIndex);
    }

    /**
     * #2 improvement of #1
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        if (0 == nums.length || 1 == nums.length)return 0;
        int i = 0, t = 0, max_val = 0, count = 0, boundry = nums[0];
        if (boundry >= nums.length - 1)
            return count + 1;
        while(i < nums.length){
            t = nums[i] + i;
            if(t > max_val){
                max_val = t;
            }
            if(boundry == i){
                ++count;
                boundry = max_val;
                if (boundry >= nums.length - 1)
                    return count + 1;
            }
            ++i;
        }
        return 0;
    }

    /**
     * #3
     * @param nums
     * @return
     */
    public int jump3(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
