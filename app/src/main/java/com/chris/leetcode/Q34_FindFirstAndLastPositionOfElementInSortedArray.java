package com.chris.leetcode;

public class Q34_FindFirstAndLastPositionOfElementInSortedArray {
    /*
    Given an array of integers nums sorted in ascending order,
    find the starting and ending position of a given target value.
    Your algorithm's runtime complexity must be in the order of O(log n).
    If the target is not found in the array, return [-1, -1].
    Example 1:
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]

    Example 2:
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]
     */
    public static void main(String[] args) {
        int[] a = {5, 7, 7, 8, 8, 10};
        new Q34_FindFirstAndLastPositionOfElementInSortedArray().searchRange2(a, 7);
        new Q34_FindFirstAndLastPositionOfElementInSortedArray().searchRange2(a, 6);
    }
    //筆記
    /*
    分別用兩個binary search找到第一個和最後一個target
    第一個的找法:
    需要把指針往頭移動, 所以n[mid]>target 則 end = mid;
    最後一個找法
    需要把指針往尾移動, 所以n[mid]<target 則 start = mid;
     */
    //binary
    public int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{-1, -1};
    }

    private int findLast(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target)
                end = mid;
            else
                start = mid;
        }
        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
    }

    private int findFirst(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < target)
                start = mid;
            else
                end = mid;
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }

    //brute-force
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        while (start < nums.length && end >= 0) {
            if (nums[start] != target)
                start++;
            else
                ans[0] = start;
            if (nums[end] != target)
                end--;
            else
                ans[1] = end;
            if (ans[0] != -1 && ans[1] != -1)
                break;
        }
        return ans;
    }
}
