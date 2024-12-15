// LeetCode Question: https://leetcode.com/problems/increasing-triplet-subsequence

package solutions.LeetCode_75.Array_String.Increasing_Triplet_Subsequence;

class Solution {
  public boolean increasingTriplet(int[] nums) {
    int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

    for (int num : nums) {
      if (num <= first) {
        first = num; // Update the smallest number
      } else if (num <= second) {
        second = num; // Update the second smallest number
      } else {
        return true; // A third number greater than 'first' and 'second' is found
      }
    }

    return false; // No increasing triplet subsequence found
  }
}
