package com.chris.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40_CombinationSumII {
    /*
    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
    Each number in candidates may only be used once in the combination.

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
    Example 1:
    Input: candidates = [10,1,2,7,6,1,5], target = 8,
    A solution set is:
    [
      [1, 7],
      [1, 2, 5],
      [2, 6],
      [1, 1, 6]
    ]
    Example 2:
    Input: candidates = [2,5,2,1,2], target = 5,
    A solution set is:
    [
      [1,2,2],
      [5]
    ]
     */
    public static void main(String[] args) {
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        new Q40_CombinationSumII().combinationSum2(a, 8);
    }

    private List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        recursive(ans, temp, candidates, target, 0);
        return ans;
    }
    // 筆記
    /*
        與39題非常類似, 差別在於這題不能有重複的值(同個位置的element不能出現兩次, 但若是不同位置elements相同的值是沒差的)
        重點就在於如何避免重複加入相同的element
        ex:i=0 start=0的這次一次遞迴跑完後
        i變成1 start依舊是0
        此時滿足了(i != start && candidates[i] == candidates[i - 1])這個條件
     */
    private void recursive(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int target, int start) {
        if (target < 0)
            return;
        if (target == 0)
            ans.add(new ArrayList<>(temp));
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1])
                continue;
            temp.add(candidates[i]);
            recursive(ans, temp, candidates, target - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
