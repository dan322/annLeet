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

    // 迭代法
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    // 字典排序  （二进制排序）
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < (1 << nums.length); ++i) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < nums.length; ++j)
                if (((i >> j) & 1) == 1)
                    subList.add(nums[j]);
            list.add(subList);
        }
        return list;
    }
}