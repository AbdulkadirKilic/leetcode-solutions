// LeetCode Question: https://leetcode.com/problems/longest-common-subsequence

package solutions.LeetCode_75.DP_Multidimensional.Longest_Common_Subsequence;

class Solution {
  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();

    // Create a DP table to store lengths of LCS
    int[][] dp = new int[m + 1][n + 1];

    // Fill the DP table
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          // Characters match, increment LCS length
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          // Characters don't match, take max from previous states
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    // Return the length of LCS in the bottom-right cell
    return dp[m][n];
  }
}
