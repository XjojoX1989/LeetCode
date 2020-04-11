package com.chris.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum {
    /*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:
    Given nums = [2, 7, 11, 15], target = 9,
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].

    筆記：
    可以通過暴力解法，套兩個迴圈逐一去找出兩個數，但這樣時間複雜度為O(n^2)
    想辦法縮減至O(n)
    可以跑一次迴圈把陣列的直放到map裡面
    再跑一次回圈從map中找出我們所需要的值
    這樣子的話為O(2n)

    在更近一步的話其實可以用一個回圈跑完
    先不把值塞入map內，而是先檢查map是否有我們要的值
    如果沒有就塞進去
    這樣就可以縮減到O(n)
     */
    public static void main(String[] args) {
        Q1_TwoSum.twoSum2(new int[]{3, 2, 4}, 6);
    }

    //O(2n)
    private static int[] twoSum2(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < length; j++) {
            int diff = target - nums[j];
            if (map.containsKey(diff) && map.get(diff) != null) {
                return new int[]{j, map.get(diff)};
            }
        }
        throw new IllegalArgumentException("not found");
    }

    //O(n)
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != null) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("not fund");
    }
}
