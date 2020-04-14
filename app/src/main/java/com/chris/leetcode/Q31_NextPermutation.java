package com.chris.leetcode;

public class Q31_NextPermutation {
    /*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
    The replacement must be in-place and use only constant extra memory.
    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1

    1 2 7 4 3 1 由後往前找到第一個最小的:2
      ^
    1 2 7 4 3 1 再從剩下的找到第一個比2大的:3
            ^
    1 3 7 4 2 1 再把2&3的位置交換

    1 3 1 2 4 7 對剩下的陣列做reverse

     */
    public static void main(String[] args) {
        int[] a = {1, 2, 7, 4, 3, 1};
        int[] b = {1, 2};
        new Q31_NextPermutation().nextPermutation(b);
    }

    private void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int smallestIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                smallestIndex = i;
                break;
            }
        }
        if (smallestIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int firstLargeIndex = -1;
        for (int i = nums.length - 1; i > smallestIndex; i--) {
            if (nums[i] > nums[smallestIndex]) {
                firstLargeIndex = i;
                break;
            }
        }
        swap(nums, smallestIndex, firstLargeIndex);
        reverse(nums, smallestIndex + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
