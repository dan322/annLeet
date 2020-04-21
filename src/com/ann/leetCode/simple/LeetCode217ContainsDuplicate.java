package com.ann.leetCode.simple;

import java.util.HashSet;
import java.util.Set;

public class LeetCode217ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            if (numSet.contains(num))
                return true;
            else
                numSet.add(num);
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            if (!numSet.add(num))
                return true;
        }
        return false;
    }
}
