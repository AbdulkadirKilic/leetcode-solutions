// LeetCode Question: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

package solutions.LeetCode_75.Intervals.Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;

class Solution {
  public int findMinArrowShots(int[][] points) {
    // Sort the intervals by their end points in ascending order
    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

    int arrows = 1; // Minimum one arrow is required
    int prevEnd = points[0][1]; // Track the end of the last burst balloon

    for (int i = 1; i < points.length; i++) {
      // If the current balloon starts after the previous one ends, shoot a new arrow
      if (points[i][0] > prevEnd) {
        arrows++;
        prevEnd = points[i][1]; // Update the end point for the current arrow
      }
    }

    return arrows;
  }
}
