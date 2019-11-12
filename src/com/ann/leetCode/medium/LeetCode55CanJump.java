package com.ann.leetCode.medium;

public class LeetCode55CanJump {
    /**
     * 超时 DFS
     * 时间复杂度：O(2^n)O(2n)，最多有 2^n2
     * n 种从第一个位置到最后一个位置的跳跃方式，其中 nn 是数组 nums 的元素个数
     * 空间复杂度：O(n)O(n)
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length < 2)
            return true;
        return jump(0, nums);
    }

    public boolean jump(int index, int[] nums) {
        int reachIndex = nums[index] + index;
        for (int i = reachIndex; i > index; i--) {
            if (i >= nums.length - 1 || i + nums[i] >= nums.length - 1)
                return true;
            if (jump(i, nums) == true) {
                return true;
            }
        }
        return false;
    }

    /**
     * 时间复杂度为O(n)
     * point: 0, 如果一个数组中所有元素都 > 0，则肯定可以到达目标元素
     * 如果数组中有0, 则要求该0元素之前的元素（非0中间段中的元素能跳过该0元素所在位置）
     * 针对数组元素中的所有元素，该元素所能到达的最远的距离是： i + nums[i] (i表示该元素所在的下标)
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        int maxReach = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxReach >= nums.length - 1)
                return true;
            if (nums[i] == 0 && maxReach <= i) {
                return false;
            }
            if (nums[i] + i > maxReach)
                maxReach = nums[i] + i;
        }
        return true;
    }

    /**
     * #3 倒推 能到达最后 就一定能到达最后一跳的点，但是最终都应该从起始位置 （下标为0的位置）
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int  lastPos = nums.length - 1;
        for(int i = nums.length -1; i>=0; i--){
            if(i + nums[i] >= lastPos){
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    /**
     * #4
     * todo ann
     * 动态规划  自底向上
     * 底向上和自顶向下动态规划的区别就是消除了回溯，在实际使用中，
     * 自底向下的方法有更好的时间效率因为我们不再需要栈空间，可以节省很多缓存开销。
     * 更重要的事，这可以让之后更有优化的空间
     * 时间复杂度：O(n^2)
     * @param nums
     * @return
     */
    public boolean canJump3(int[] nums) {

        return false;
    }

    /**
     * #5
     * @param A
     * @return
     */
    public boolean canJump4(int[] A) {
        int max = 0;
        for(int i=0;i<A.length;i++){
            if(i>max) {return false;}
            max = Math.max(A[i]+i,max);
        }
        return true;
    }
}
