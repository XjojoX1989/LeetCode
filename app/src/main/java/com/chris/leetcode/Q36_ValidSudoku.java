package com.chris.leetcode;

import java.util.HashSet;

public class Q36_ValidSudoku {
    /**
     * Determine if a 9x9 Sudoku board is
     * valid. Only the filled cells need to be validated according to the following rules:
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * <p>
     * Input:
     * {"5","3",".",".","7",".",".",".","."},
     * {"6",".",".","1","9","5",".",".","."},
     * {".","9","8",".",".",".",".","6","."},
     * {"8",".",".",".","6",".",".",".","3"},
     * {"4",".",".","8",".","3",".",".","1"},
     * {"7",".",".",".","2",".",".",".","6"},
     * {".","6",".",".",".",".","2","8","."},
     * {".",".",".","4","1","9",".",".","5"},
     * {".",".",".",".","8",".",".","7","9"}
     * Output: true
     * Input:
     * {'8','3','.','.','7','.','.','.','.'},
     * {'6','.','.','1','9','5','.','.','.'},
     * {'.','9','8','.','.','.','.','6','.'},
     * {'8','.','.','.','6','.','.','.','3'},
     * {'4','.','.','8','.','3','.','.','1'},
     * {'7','.','.','.','2','.','.','.','6'},
     * {'.','6','.','.','.','.','2','8','.'},
     * {'.','.','.','4','1','9','.','.','5'},
     * {'.','.','.','.','8','.','.','7','9'}
     * Output: false
     * Explanation: Same as Example 1, except with the 5 in the top left corner being
     * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
     */
    public static void main(String[] args) {
        char[][] a = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Q36_ValidSudoku().isValidSudoku(a);
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                if (!isValid(board, i, j))
                    return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j) {
        //行判斷
        for (int row = 0; row < board.length; row++) {
            if (row == i) continue;
            if (board[row][j] == board[i][j]) return false;
        }
        //列判斷
        for (int col = 0; col < board[0].length; col++) {
            if (col == j) continue;
            if (board[i][col] == board[i][j]) return false;
        }
        //小的3*3九宮格判斷
        for (int row = (i / 3) * 3; row < (i / 3 + 1) * 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3 + 1) * 3; col++) {
                if (row == i && col == j) continue;
                if (board[row][col] == board[i][j])
                    return false;
            }
        }
        return true;
    }
}
