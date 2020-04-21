package com.chris.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q56_MergeIntervals {
    /*
    Given a collection of intervals, merge all overlapping intervals.
    Example 1:
    Input: [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    Example 2:
    Input: [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     */
    public int[][] merge(int[][] intervals) {
        List<Integer> all = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[0].length; j++) {
                all.add(intervals[i][j]);
            }
        }

        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < all.size() - 1; i++) {
            int j = i + 1;
            while (j < all.size()) {
                int[] a = new int[2];
                a[0] = all.get(i);
                a[1] = all.get(j);
                set.add(a);
                j++;
            }
        }
        return set.toArray(new int[set.size()][]);
    }

    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        new Q56_MergeIntervals().merge(a);
    }
}
