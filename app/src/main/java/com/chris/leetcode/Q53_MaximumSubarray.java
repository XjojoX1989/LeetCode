package com.chris.leetcode;

public class Q53_MaximumSubarray {
    /*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
    Example:
    Input: [-2,1,-3,4,-1,2,1,-5,4],
            -2,1,-2,4,3,
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    Follow up:
    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     */

    private int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = nums[0];
        int max =Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            sum = sum < 0 ? nums[i] : sum + nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        new Q53_MaximumSubarray().maxSubArray(a);
    }
}
