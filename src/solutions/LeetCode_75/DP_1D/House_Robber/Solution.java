// LeetCode Question: https://leetcode.com/problems/house-robber

package solutions.LeetCode_75.DP_1D.House_Robber;

class Solution {
  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0]; // Only one house to rob

    int prev2 = 0; // Money from two houses before
    int prev1 = 0; // Money from the last house

    for (int num : nums) {
      int curr = Math.max(prev1, prev2 + num);
      prev2 = prev1;
      prev1 = curr;
    }

    return prev1; // Maximum money that can be robbed
  }
}
