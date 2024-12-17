// LeetCode Question: https://leetcode.com/problems/equal-row-and-column-pairs

package solutions.LeetCode_75.HashMap_Set.Equal_Row_and_Column_Pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int equalPairs(int[][] grid) {
    int n = grid.length;
    Map<String, Integer> rowMap = new HashMap<>();
    int count = 0;

    // Convert each row into a string and count occurrences
    for (int[] row : grid) {
      String rowStr = Arrays.toString(row);
      rowMap.put(rowStr, rowMap.getOrDefault(rowStr, 0) + 1);
    }

    // Compare each column with the rowMap
    for (int col = 0; col < n; col++) {
      int[] column = new int[n];
      for (int row = 0; row < n; row++) {
        column[row] = grid[row][col];
      }
      String colStr = Arrays.toString(column);
      count += rowMap.getOrDefault(colStr, 0);
    }

    return count;
  }
}
