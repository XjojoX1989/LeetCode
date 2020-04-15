package com.chris.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39_CombinationSum {
    /**
     * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
     * <p>
     * The same repeated number may be chosen from candidates unlimited number of times.
     * <p>
     * Note:
     * <p>
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     * <p>
     * Input: candidates = [2,3,6,7], target = 7,
     * A solution set is:
     * [
     * [7],
     * [2,2,3]
     * ]
     * Example 2:
     * <p>
     * Input: candidates = [2,3,5], target = 8,
     * A solution set is:
     * [
     * [2,2,2,2],
     * [2,3,3],
     * [3,5]
     * ]
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        recursor(result, temp, target, candidates, 0);

        return result;
    }

    private void recursor(List<List<Integer>> result, List<Integer> temp, int target, int[] candidates, int start) {
        if (target < 0) return;
        if (target == 0) {
            System.out.println("target=0");
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            System.out.println("recursor");
            recursor(result, temp, target - candidates[i], candidates, i);
            System.out.println("remove");
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5};
        new Q39_CombinationSum().combinationSum(a, 8);
    }
}
