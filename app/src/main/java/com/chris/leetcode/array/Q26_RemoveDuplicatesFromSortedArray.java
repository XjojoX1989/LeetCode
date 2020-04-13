package com.chris.leetcode.array;

public class Q26_RemoveDuplicatesFromSortedArray {
    /*
    Given a sorted array nums, remove the duplicates in-place such that
    each element appear only once and return the new length.
    Do not allocate extra space for another array,

    you must do this by modifying the input array in-place with O(1) extra memory.
    Example 1:
    Given nums = [1,1,2],
    Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
    It doesn't matter what you leave beyond the returned length.

    Example 2:
    Given nums = [0,0,1,1,1,2,2,3,3,4],
    Your function should return length = 5, with the first five elements of nums being modified to
    0, 1, 2, 3, and 4 respectively.
    It doesn't matter what values are set beyond the returned length.
         */
    //筆記
    /*
    利用兩個指針p1, p2
    p1先走,如過p1指向的值＝p2
    p1繼續走＋＋
    如果p1指向的值!＝p2
    則p2++, 且p2指向的陣列直須替換為p1的值（題目要求）
    直到p1走完, p2的值就是不同的個數
     */
    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] b = {1, 1, 2};
        new Q26_RemoveDuplicatesFromSortedArray().removeDuplicates2(a);
        new Q26_RemoveDuplicatesFromSortedArray().removeDuplicates2(b);
    }

    private int removeDuplicates2(int[] nums) {
        int length = nums.length;
        int fast = 0;
        int slow = 0;
        while (fast < length) {
            if (nums[fast] == nums[slow])
                fast++;
            else {
                nums[slow + 1] = nums[fast];
                slow++;
            }
        }
        return slow + 1;
    }

    private int removeDuplicates(int[] nums) {
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
