package com.chris.leetcode;

public class Q59_SpiralMatrixII {
    /*
    Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
    Example:
    Input: 3
    Output:
            [ 1, 2, 3 ],
            [ 8, 9, 4 ],
            [ 7, 6, 5 ]
     */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int top = 0, right = n - 1, left = 0, bottom = n - 1;
        int current = 1;
        while (true) {
            if (top > bottom) break;
            for (int i = left; i <= right; i++) {
                ans[top][i] = current++;
            }
            top++;

            if (right < left) break;
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = current++;
            }
            right--;

            if (bottom < top) break;
            for (int i = right; i >= left; i--) {
                ans[bottom][i] = current++;
            }
            bottom--;

            if (left > right) break;
            for (int i = bottom; i >= top; i--) {
                ans[i][left] = current++;
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Q59_SpiralMatrixII().generateMatrix(3);
    }
}
