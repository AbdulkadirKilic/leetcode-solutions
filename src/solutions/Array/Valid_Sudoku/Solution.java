// LeetCode Question: https://leetcode.com/problems/valid-sudoku

package solutions.Array.Valid_Sudoku;

class Solution {
  public boolean isValidSudoku(char[][] board) {
    // Array to track rows, columns, and 3x3 sub-boxes
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] boxes = new boolean[9][9];

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          int num = board[i][j] - '1'; // Convert char to integer index (0-8)
          int boxIndex = (i / 3) * 3 + j / 3; // Determine which 3x3 box

          // Check if the number already exists in the row, column, or box
          if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
            return false;
          }

          // Mark the number as seen in the respective row, column, and box
          rows[i][num] = true;
          cols[j][num] = true;
          boxes[boxIndex][num] = true;
        }
      }
    }
    return true; // If no conflicts, the board is valid
  }
}
