package com.chris.leetcode;

public class Q33_SearchInRotatedSortedArray {
    /*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
    You are given a target value to search. If found in the array return its index, otherwise return -1.
    You may assume no duplicate exists in the array.
    Your algorithm's runtime complexity must be in the order of O(log n).

    Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

    Example 2:
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1
     */
    //筆記
    /*
    此題為旋轉陣列的經典題
    使用二分法去找出target
    在給定的有序陣列中, 會於任意的點進行旋轉
    接著我們找出陣列的中間位置mid=(end-tart)/2+start，把陣列分成 a,b兩個子陣列
    如果n[mid] = target就直接找到了。
    然後我們須先找到旋轉後的有序排列那一組
    怎麼找呢？我們運用兩個pointer start & end
    有兩種情況
    I. 如果 start的值 < mid的值, 代表a是有序排列
    II. 如果  end的值 > mid的值, 代表b是有序排列
    再分別從I & II兩種繼續找
    I中又可以分成兩種
     若是n[start]<target<n[mid], 則把end移到mid, 下一次的循環找再一次mid
     反之把start移到mid
    II也可以分兩種
     若是n[mid]<target<n[end], 則把start移到mid, 下一次的循環找再一次mid
     反之把end移到mid;
     */
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        new Q33_SearchInRotatedSortedArray().search(a, 1);
    }

    private int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) return mid;
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else
                    start = mid;
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else
                    end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
}