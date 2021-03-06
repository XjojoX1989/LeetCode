package com.chris.leetcode;

public class Q48_RotateImage {
    /*
  You are given an n x n 2D matrix representing an image.

  Rotate the image by 90 degrees (clockwise).

  Note:

  You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

  Example 1:

  Given input matrix =
  [
    [1,2,3],
    [4,5,6],
    [7,8,9]
  ],

  rotate the input matrix in-place such that it becomes:
  [
    [7,4,1],
    [8,5,2],
    [9,6,3]
  ]

    1,4,7
    2,5,8
    3,6,9
  */
    //筆記
    /*
    圖形的翻轉重點在於用什麼樣的方法去翻轉
    我們可以先把二階陣列中的每個位置的 i,j互換
    因為是順時針轉的關係, 所以接著再沿著Y軸翻轉也就是 i不變,改變j
    所以如果是逆時針轉的話,  就變成沿著Y軸翻轉       i改變,j不變
     */
    private void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - 1 - j];
                matrix[i][length - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Q48_RotateImage().rotate(a);
    }
}
