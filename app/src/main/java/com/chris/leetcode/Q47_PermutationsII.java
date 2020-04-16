package com.chris.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47_PermutationsII {
    /*
    Given a collection of numbers that might contain duplicates,
    return all possible unique permutations.

    Example:
    Input: [1,1,2]
    Output:
    [
      [1,1,2],
      [1,2,1],
      [2,1,1]
    ]
     */
    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        new Q47_PermutationsII().permute(a);
    }

    private List<List<Integer>> permute(int[] array) {
        List<List<Integer>> ans = new ArrayList<>();
        if (array == null || array.length == 0) return ans;
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(array);
        recurisve(ans, temp, array, new boolean[array.length]);
        return ans;
    }

    private void recurisve(List<List<Integer>> ans, List<Integer> temp, int[] array, boolean[] used) {
        if (temp.size() == array.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (used[i] || i > 0 && array[i] == array[i - 1] && !used[i - 1])
                continue;
            temp.add(array[i]);
            used[i] = true;
            recurisve(ans, temp, array, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
