package com.chris.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q46_Permutations {
    /*
    Given a collection of distinct integers, return all possible permutations.
    Example:
    Input: [1,2,3]
    Output:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        new Q46_Permutations().permute(a);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        List<Integer> temp = new ArrayList<>();
        recursive(ans, temp, nums);
        return ans;
    }

    private void recursive(List<List<Integer>> ans, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i]))
                continue;
            temp.add(nums[i]);
            recursive(ans, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
