// LeetCode Question: https://leetcode.com/problems/min-cost-climbing-stairs

package solutions.LeetCode_75.DP_1D.Min_Cost_Climbing_Stairs;

class Solution {
  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int prev2 = 0; // Cost to reach two steps before
    int prev1 = 0; // Cost to reach one step before

    for (int i = 2; i <= n; i++) {
      int curr = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
      prev2 = prev1;
      prev1 = curr;
    }

    return prev1; // Minimum cost to reach the top
  }
}
