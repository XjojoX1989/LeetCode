package com.chris.leetcode.array;

import java.util.Arrays;

public class Q16_ThreeSumClosest {
    /*
    Example:

    Given array nums = [-1, 2, 1, -4], and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    給一個陣列[-1, 2, 1, -4], 要找出合與target最近的三個數
    target = 1, 三個數 = -1, 2, 1  其合 = 2; <-最近
    target = 1, 三個數 = -1, 1, -4 其合 = -4;
    target = 1, 三個數 = -1, 2, -4 其合 = -3;
    target = 1, 三個數 = 2, 1, -4  其合 = -1;
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 8, 16, 32, 64, 128};
        int[] b = {-1, 2, 1, -4};
        System.out.println(new Q16_ThreeSumClosest().threeSumClosest2(b, 1));
    }

    /*
    筆記
    找到三個離目標最接近的和
    外面使用for迴圈拜訪每個數
    內一樣用兩個pointer的方式逐一去找
    找什麼？
    假設 p1 + p2 + 當前for輪到的數 = target
    (target - 當前for輪到的數) = 與目標的差
    則 p1 + p2 盡可能接近 與目標的差
    這就是我們要找的東西

    如果 p1+p2 > 與目標的差
    代表 p2需要往“前”移

    如果 p1+p2 < 與目標的差
    代表 p1需要往”後“移
     */
    private int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int ans = 0;
        int minDiff = Integer.MAX_VALUE;
        //-4,-1,2,1 target = 1
        for (int i = 0; i < length - 2; i++) {
            int p1 = i + 1;
            int p2 = length - 1;
            int offset = target - nums[i];//與目標的差
            while (p1 < p2) {
                int sumOfPointer = nums[p1] + nums[p2];
                int currentDiff = Math.abs(offset - sumOfPointer);
                if (currentDiff < minDiff) {
                    minDiff = currentDiff;
                    ans = sumOfPointer + nums[i];
                }
                if (sumOfPointer > offset)
                    p2--;
                else
                    p1++;
            }
        }
        return ans;

    }

    private int threeSumClosest(int[] nums, int target) {
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
