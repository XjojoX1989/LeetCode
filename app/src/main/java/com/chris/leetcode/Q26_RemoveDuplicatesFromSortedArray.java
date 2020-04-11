package com.chris.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q26_RemoveDuplicatesFromSortedArray {
    /*
    Given a sorted array nums, remove the duplicates in-place such that
    each element appear only once and return the new length.

    Do not allocate extra space for another array,
    you must do this by modifying the input array in-place with O(1) extra memory.
     */

    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] b = {1, 1, 2};
        new Q26_RemoveDuplicatesFromSortedArray().removeDuplicates(a);
        new Q26_RemoveDuplicatesFromSortedArray().removeDuplicates(b);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int pointer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[pointer]) {
                pointer++;
                nums[pointer] = nums[i];
            }
        }
        return pointer + 1;
    }
}
