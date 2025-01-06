// LeetCode Question: https://leetcode.com/problems/non-overlapping-intervals

package solutions.LeetCode_75.Intervals.Non_overlapping_Intervals;

import java.util.Arrays;

class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1])); // Sort intervals by end times
    int count = 0;
    int lastEnd = Integer.MIN_VALUE;

    for (int[] interval : intervals) {
      if (interval[0] >= lastEnd) {
        lastEnd = interval[1]; // Update last end time
      } else {
        count++; // Increment count for overlapping interval
      }
    }
    return count;
  }
}
