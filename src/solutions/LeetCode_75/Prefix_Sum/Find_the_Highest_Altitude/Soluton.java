// LeetCode Question: https://leetcode.com/problems/find-the-highest-altitude

package solutions.LeetCode_75.Prefix_Sum.Find_the_Highest_Altitude;

class Solution {
  public int largestAltitude(int[] gain) {
    int currentAltitude = 0, maxAltitude = 0;

    for (int g : gain) {
      currentAltitude += g;
      maxAltitude = Math.max(maxAltitude, currentAltitude);
    }

    return maxAltitude;
  }
}
