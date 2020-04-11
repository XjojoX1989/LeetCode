package com.chris.leetcode.array;

public class Q11_ContainerWithMostWater {
    /*
    Given n non-negative integers a1, a2, ..., an ,
    where each represents a point at coordinate (i, ai).
    n vertical lines are drawn such that
    the two endpoints of line i is at (i, ai) and (i, 0).
    Find two lines, which together with x-axis forms a container,
    such that the container contains the most water.
    Note: You may not slant the container and n is at least 2.
    Example:
    Input: [1,8,6,2,5,4,8,3,7]  Output: 49
     */
    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Q11_ContainerWithMostWater().maxArea2(a));
    }
    /*
    計算最大的容積
    設計兩個指針，一個指向頭一個指向尾
    每次計算面積後跟前一次比較取大的
    而頭指針的值若是小於尾則頭++，反正尾--
     */
    private int maxArea2(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;
        while (i < j) {
            maxArea = Math.max(Math.min(height[i], height[j]) * (j - i), maxArea);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    private int maxArea(int[] height) {
        int res = 0, i = 0, j = height.length - 1;
        while (i < j) {
            res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return res;
    }
}
