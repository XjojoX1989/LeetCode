package com.chris.leetcode;

import java.util.Arrays;

public class Q16_ThreeSumClosest {
    /*
    Example:

    Given array nums = [-1, 2, 1, -4], and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(new Q16_ThreeSumClosest().threeSumClosest(a, 82));
    }

    /*
    給一個陣列[-1, 2, 1, -4], 要找出合與target最近的三個數
    target = 1, 三個數 = -1, 2, 1  其合 = 2; <-最近
    target = 1, 三個數 = -1, 1, -4 其合 = -4;
    target = 1, 三個數 = -1, 2, -4 其合 = -3;
    target = 1, 三個數 = 2, 1, -4  其合 = -1;
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            int currentTarget = target - nums[i];
            while (low < high) {
                int sum = nums[low] + nums[high] + nums[i];
                int diff = Math.abs(target - sum);
                if (diff < minDiff) {
                    minDiff = diff;
                    result = sum;
                }
                if (nums[low] + nums[high] > currentTarget)
                    high--;
                else
                    low++;
            }
        }
        return result;

    }


}
