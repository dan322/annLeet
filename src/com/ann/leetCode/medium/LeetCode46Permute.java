package com.ann.leetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> oldList = new ArrayList<>();
        oldList.add(new ArrayList<>());
        for (int i = 0; i < nums.length; ++i) {
            for (List<Integer> subList: oldList) {
                List<Integer> newSub = new ArrayList<>();
                for (int j = 0; j <= i; ++j) {
                    newSub.addAll(subList);
                    newSub.add(j, nums[i]);
                    list.add(newSub);
                    newSub = new ArrayList<>();
                }
            }
            oldList = list;
            list = new ArrayList<>();
        }
        return oldList;
    }

    // todo 递归
    public List<List<Integer>> permute1(int[] nums) {
        return null;
    }

    // todo 递归 回溯 improvement
    public List<List<Integer>> permute2(int[] nums) {
        return null;
    }
}
