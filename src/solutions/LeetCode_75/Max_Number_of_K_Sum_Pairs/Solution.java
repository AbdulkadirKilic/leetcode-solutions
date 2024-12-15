// LeetCode Question: https://leetcode.com/problems/max-number-of-k-sum-pairs

package solutions.LeetCode_75.Max_Number_of_K_Sum_Pairs;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int maxOperations(int[] nums, int k) {
    Map<Integer, Integer> countMap = new HashMap<>();
    int operations = 0;

    for (int num : nums) {
      int complement = k - num;
      if (countMap.getOrDefault(complement, 0) > 0) {
        operations++;
        countMap.put(complement, countMap.get(complement) - 1);
      } else {
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
      }
    }

    return operations;
  }
}
