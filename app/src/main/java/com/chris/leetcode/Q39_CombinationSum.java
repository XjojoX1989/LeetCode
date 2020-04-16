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
    //筆記
    /*
    組合的經典題型,使用遞迴的方法去解
    每一次我們都先把陣列裡的element加進去
    根據題目要求可以重複,所以我們下一次的遞迴的起點還是在同一個
    不過傳進去的遞迴target必須減去當前element
    一直遞迴到target=0表示陣列內的元素可以組合出target
    若遞迴到target<0則表示無法組合出
     */

    private void recursor(List<List<Integer>> result, List<Integer> temp, int target, int[] candidates, int start) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            recursor(result, temp, target - candidates[i], candidates, i);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 5};
        new Q39_CombinationSum().combinationSum(a, 8);
    }
}
