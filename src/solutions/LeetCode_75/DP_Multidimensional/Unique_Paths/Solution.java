// LeetCode Question: https://leetcode.com/problems/unique-paths

package solutions.LeetCode_75.DP_Multidimensional.Unique_Paths;

class Solution {
  public int uniquePaths(int m, int n) {
    // Create a 2D array to store the number of unique paths
    int[][] dp = new int[m][n];

    // Fill the first row with 1, as there is only one way to move right
    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }

    // Fill the first column with 1, as there is only one way to move down
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    // Fill the rest of the dp table
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }

    // The bottom-right cell contains the number of unique paths
    return dp[m - 1][n - 1];
  }
}
