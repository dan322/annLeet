package com.ann.leetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode89GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> codeList = new ArrayList<Integer>() {{add(0);}};
        for (int i = 0; i < n; ++i) {
            int j = codeList.size() - 1;
            for (; j >= 0; --j) {
                int num = codeList.get(j);
                codeList.add((num | 1 << i));
            }
        }
        return codeList;
    }
}
