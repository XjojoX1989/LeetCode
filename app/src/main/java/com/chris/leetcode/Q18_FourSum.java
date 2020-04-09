package com.chris.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18_FourSum {
    /*
    Given an array nums of n integers and an integer target,
    are there elements a, b, c, and d in nums such that a + b + c + d = target?
    Find all unique quadruplets in the array which gives the sum of target.

    Note:

    The solution set must not contain duplicate quadruplets.

    Example:

    Given array nums = [1, 0, -1, 0, -2], and target = 0.

    A solution set is:
    [
      [-1,  0, 0, 1],
      [-2, -1, 1, 2],
      [-2,  0, 0, 2]
    ]
     */
    public static void main(String[] args) {
        int[] a = {1, 0, -1, 0, -2};
        new Q18_FourSum().fourSum(a, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = length - 1; j > i + 2; j--) {
                if (j < length - 1 && nums[j] == nums[j + 1]) { // 第四個數使用不重複
                    continue;
                }

                int start = i + 1; // 第二個數
                int end = j - 1; // 第三個數
                int n = target - nums[i] - nums[j];
                while (start < end) {
                    if (nums[start] + nums[end] == n) {
                        List<Integer> four = new ArrayList<>();
                        four.add(nums[i]);
                        four.add(nums[start]);
                        four.add(nums[end]);
                        four.add(nums[j]);
                        result.add(four);
                        do {
                            start++;
                        } while (start < end && nums[start] == nums[start - 1]); // 保證再次使用第二個數不會重複

                        do {
                            end--;
                        } while (start < end && nums[end] == nums[end + 1]); // 保證再次使用第三個數不會重複
                    } else if (nums[start] + nums[end] < n) { //若中間兩個pointer的和太小需要將第二個指針右移
                        do {
                            start++;
                        } while (start < end && nums[start] == nums[start - 1]); // 保證再次使用第二個數不會重複
                    } else {//若中間兩個pointer的和太大需要將第三個指針左移
                        do {
                            end--;
                        } while (start < end && nums[end] == nums[end + 1]); // 保證再次使用第三個數不會重複
                    }
                }
            }
        }
        return null;
    }
}
