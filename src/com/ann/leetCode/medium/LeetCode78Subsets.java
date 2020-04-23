package com.ann.leetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        generateSubSet(list, 0, nums, arrayList);
        return list;
    }

    public void generateSubSet(List<List<Integer>> listSet, int index, int[] nums, ArrayList<Integer> list) {
        if (index == nums.length) {
            listSet.add(list);
        } else {
            generateSubSet(listSet, index + 1, nums, list);
            ArrayList<Integer> newList = (ArrayList<Integer>) list.clone();
            newList.add(nums[index]);
            generateSubSet(listSet, index + 1, nums, newList);
        }
    }
}