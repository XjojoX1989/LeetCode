package com.chris.leetcode;

public class Q35_SearchInsertPosition {
    /**
     * Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array
     * <p>
     * Input: [1,3,5,6], 5      Input: [1,3,5,6], 2
     * Output: 2                Output: 1
     * <p>
     * <p>
     * Input: [1,3,5,6], 7     Input: [1,3,5,6], 0
     * Output: 4               Output: 0
     */
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) return nums.length;
        if (target < nums[0]) return 0;
        int p = 0;
        while (p < nums.length) {
            if (nums[p] < target)
                p++;
            else
                break;
        }
        return p == -1 ? nums.length + 1 : p;
    }

    //0 1 2 3 4 5 6 7 8 9  ,2 ,7
    public int searchInsert2(int[] nums, int target) {
        int low = 0, hi = nums.length - 1;
        while (low < hi) {
            int mid = (hi - low) / 2 + low;
            if (nums[mid] < target)
                low = mid;
            else
                hi = mid;
        }
        return hi;
    }

    public static void main(String[] args) {

    }
}
