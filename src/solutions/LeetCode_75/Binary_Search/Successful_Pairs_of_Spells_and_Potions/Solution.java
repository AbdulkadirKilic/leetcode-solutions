// LeetCode Question: https://leetcode.com/problems/successful-pairs-of-spells-and-potions

package solutions.LeetCode_75.Binary_Search.Successful_Pairs_of_Spells_and_Potions;

import java.util.Arrays;

class Solution {
  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    // Sort the potions array to perform binary search
    Arrays.sort(potions);
    int n = potions.length;
    int[] result = new int[spells.length];

    for (int i = 0; i < spells.length; i++) {
      int spell = spells[i];
      // Calculate the minimum potion strength needed for success
      long required = (success + spell - 1) / spell; // Avoid division issues
      // Find the first valid potion using binary search
      int index = binarySearch(potions, required);
      // Calculate the number of successful pairs
      result[i] = n - index;
    }

    return result;
  }

  private int binarySearch(int[] potions, long required) {
    int low = 0, high = potions.length;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (potions[mid] >= required) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}
