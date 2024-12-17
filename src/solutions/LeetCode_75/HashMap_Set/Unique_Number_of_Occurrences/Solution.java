// LeetCode Question: https://leetcode.com/problems/unique-number-of-occurrences

package solutions.LeetCode_75.HashMap_Set.Unique_Number_of_Occurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> countMap = new HashMap<>();
    Set<Integer> occurrenceSet = new HashSet<>();

    // Count the occurrences of each element
    for (int num : arr) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    // Check if occurrences are unique
    for (int count : countMap.values()) {
      if (!occurrenceSet.add(count)) {
        return false;
      }
    }

    return true;
  }
}
