package com.chris.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum {
    public static void main(String[] args) {
        Q1_TwoSum.twoSum(new int[]{3, 2, 4}, 6);
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int offset = target - nums[i];
            if (map.containsKey(offset) && map.get(offset)!=i) {
                return new int[]{i, map.get(offset)};
            }
        }
        throw new IllegalArgumentException("not fund");
    }
}
