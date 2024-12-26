// LeetCode Question: https://leetcode.com/problems/domino-and-tromino-tiling

package solutions.LeetCode_75.DP_1D.Domino_and_Tromino_Tiling;

class Solution {
  public int numTilings(int n) {
    if (n == 1) return 1; // Base case: Only one way to tile a 2x1 board
    if (n == 2) return 2; // Base case: Two ways to tile a 2x2 board

    int MOD = 1_000_000_007;
    long[] dp = new long[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 5; // Precomputed value for n=3

    for (int i = 4; i <= n; i++) {
      dp[i] = (2 * dp[i - 1] % MOD + dp[i - 3] % MOD) % MOD;
    }

    return (int) dp[n];
  }
}
