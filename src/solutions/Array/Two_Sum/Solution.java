// LeetCode Question: https://leetcode.com/problems/two-sum

package solutions.Array.Two_Sum;

import java.util.HashMap;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>(); // To store the numbers and their indices

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      // Check if the complement exists in the map
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }

      // Store the current number with its index
      map.put(nums[i], i);
    }

    // This point is never reached due to the problem's constraints
    throw new IllegalArgumentException("No solution found");
  }
}
