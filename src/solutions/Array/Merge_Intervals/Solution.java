// LeetCode Question: https://leetcode.com/problems/merge-intervals

package solutions.Array.Merge_Intervals;

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 0) return new int[0][];

    // Sort intervals by their start value
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    LinkedList<int[]> merged = new LinkedList<>();

    for (int[] interval : intervals) {
      // If the list is empty or the current interval does not overlap with the previous
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        merged.add(interval);
      } else {
        // Merge intervals by updating the end of the last interval in the list
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }

    return merged.toArray(new int[merged.size()][]);
  }
}
