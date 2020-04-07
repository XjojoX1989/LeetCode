package com.chris.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q15_ThreeSum {
    /*
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    Note:

    The solution set must not contain duplicate triplets.

    Example:

    Given array nums = [-1, 0, 1, 2, -1, -4],

    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
     */
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        new Q15_ThreeSum().threeSum(a);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//有小到大排列
        List<List<Integer>> res = new ArrayList<>();
        Map<List<Integer>, Integer> checkDupe = new HashMap<>();
        //採取兩個指標分別從頭尾掃描
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {//第二個條件可以避免重複掃描, 如果你下一個跟現在的數是一樣的代表會重複掃描
                int start = i + 1;
                int end = nums.length - 1;
                int target = 0 - nums[i];
                //頭尾掃描的合需等於target
                while (start < end) {
                    if (nums[start] + nums[end] == target) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[start], nums[end]);
                        if (checkDupe.isEmpty() || checkDupe.get(temp) == null) {
                            res.add(temp);
                            checkDupe.put(temp, i);
                        }
                        start++;
                        end--;
                    } else if (nums[start] + nums[end] > target) {//如果頭+尾>target表示太大, 所以尾要往前移動一個指標
                        end--;
                    } else {//這個就是 頭+尾<target 表示太小, 所以頭要往後移動一個指標
                        start++;
                    }
                }
            }

        }


//        Arrays.sort(nums);
//        List<List<Integer>> res = new LinkedList();
//        Map<List<Integer>, Integer> checkDupe = new HashMap();
//        for (int i = 0; i < nums.length - 2; i++) {
//
//            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
//                int low = i + 1;
//                int high = nums.length - 1;
//                int sum = 0 - nums[i];
//                while (low < high) {
//                    if (sum == nums[low] + nums[high]) {
//                        List<Integer> resAdd = Arrays.asList(nums[i], nums[low], nums[high]);
//                        if (checkDupe.size() == 0 || checkDupe.get(resAdd) == null) {
//                            res.add(resAdd);
//                            checkDupe.put(resAdd, i);
//                        }
//                        low++;
//                        high--;
//                    } else if (sum > nums[low] + nums[high]) {
//                        low++;
//                    } else {
//                        high--;
//                    }
//                }
//
//            }
//        }
        return res;
    }
}
