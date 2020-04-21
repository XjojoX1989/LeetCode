package com.chris.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q54_SpiralMatrix {
    /*
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    Example 1:
    Input:
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    Output: [1,2,3,6,9,8,7,4,5]

    Example 2:
    Input:
      [1, 2, 3, 4],
      [5, 6, 7, 8],
      [9,10,11,12]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0, down = m - 1, left = 0, right = n - 1;
        while (true) {
            if (up > down) break;
            for (int i = left; i <= right; i++) {
                spiral.add(matrix[up][i]);
            }
            up++;

            if (right < left) break;
            for (int j = up; j <= down; j++) {
                spiral.add(matrix[j][right]);
            }
            right--;

            if (down < up) break;
            for (int k = right; k >= left; k--) {
                spiral.add(matrix[down][k]);
            }
            down--;

            if (left > right) break;
            for (int k = down; k >= up; k--) {
                spiral.add(matrix[k][left]);
            }
            left++;

        }
        return spiral;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        new Q54_SpiralMatrix().spiralOrder(a);
    }
}
