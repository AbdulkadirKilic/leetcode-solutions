// LeetCode Question: https://leetcode.com/problems/n-queens

package solutions.Array.N_Queens;

import java.util.*;

class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> solutions = new ArrayList<>();
    char[][] board = new char[n][n];

    for (char[] row : board) {
      Arrays.fill(row, '.');
    }

    solve(0, board, solutions, n);
    return solutions;
  }

  private void solve(int row, char[][] board, List<List<String>> solutions, int n) {
    if (row == n) {
      solutions.add(constructBoard(board));
      return;
    }

    for (int col = 0; col < n; col++) {
      if (isSafe(board, row, col, n)) {
        board[row][col] = 'Q';
        solve(row + 1, board, solutions, n);
        board[row][col] = '.';
      }
    }
  }

  private boolean isSafe(char[][] board, int row, int col, int n) {
    for (int i = 0; i < row; i++) {
      if (board[i][col] == 'Q') return false;
    }

    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q') return false;
    }

    for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
      if (board[i][j] == 'Q') return false;
    }

    return true;
  }

  private List<String> constructBoard(char[][] board) {
    List<String> result = new ArrayList<>();
    for (char[] row : board) {
      result.add(new String(row));
    }
    return result;
  }
}
