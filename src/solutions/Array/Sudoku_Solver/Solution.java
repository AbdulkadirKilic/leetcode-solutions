// LeetCode Question: https://leetcode.com/problems/sudoku-solver

package solutions.Array.Sudoku_Solver;

class Solution {
  public void solveSudoku(char[][] board) {
    solve(board);
  }

  private boolean solve(char[][] board) {
    // Traverse the board to find an empty cell
    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        if (board[row][col] == '.') {
          // Try placing digits 1 to 9 in the empty cell
          for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, row, col, num)) {
              board[row][col] = num; // Place the number
              if (solve(board)) {
                return true; // Solution found
              }
              board[row][col] = '.'; // Backtrack
            }
          }
          return false; // No valid number found
        }
      }
    }
    return true; // All cells are filled
  }

  private boolean isValid(char[][] board, int row, int col, char num) {
    int boxRowStart = (row / 3) * 3;
    int boxColStart = (col / 3) * 3;

    for (int i = 0; i < 9; i++) {
      if (board[row][i] == num
          || board[i][col] == num
          || board[boxRowStart + i / 3][boxColStart + i % 3] == num) {
        return false; // Number conflicts with row, column, or 3x3 box
      }
    }
    return true; // Number is valid
  }
}
