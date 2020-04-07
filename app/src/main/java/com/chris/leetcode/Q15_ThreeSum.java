package com.chris.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q15_ThreeSum {
    /*
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    Note:

    The solution set must not contain duplicate triplets.

    Example:

    Given array nums = [-1, 0, 1, 2, -1, -4],

    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
     */
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        new Q15_ThreeSum().threeSum(a);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList();
        Map<List<Integer>, Integer> checkDupe = new HashMap();
        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (sum == nums[low] + nums[high]) {
                        List<Integer> resAdd = Arrays.asList(nums[i], nums[low], nums[high]);
                        if (checkDupe.size() == 0 || checkDupe.get(resAdd) == null) {
                            res.add(resAdd);
                            checkDupe.put(resAdd, i);
                        }
                        low++;
                        high--;
                    } else if (sum > nums[low] + nums[high]) {
                        low++;
                    } else {
                        high--;
                    }
                }

            }
        }
        return res;
    }
}
